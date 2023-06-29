package source.refactor.changeLongComplicatedMethod;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class InvoiceService {
    private String connectionString;

    public InvoiceService() throws IOException {
    	
        this.connectionString = AppSettings.getConnectionString();
    }

    public DbInvoice addInvoiceLine(String id, InvoiceLineCommand line) throws Exception {
    	
        DbInvoice inv = new DbInvoice();

        if (line != null) {
        	
        	if (!id.isBlank()) {
            	
        		Connection connection = DriverManager.getConnection(connectionString);
                connection.setAutoCommit(false);

                int invoiceNumber = Integer.parseInt(id);

                DbInvoice i = DbInvoiceReader.getInvoice(invoiceNumber, connection);

                if (i != null) {
                	
                	String insertCmdStr = "INSERT INTO [dbo].[InvoiceLines] ([InvoiceId], [InvoiceNumber], [ProductId], [ProductName], [ProductSKU], [Quantity], [Subtotal], [LineNumber]) VALUES (?, ?, ?, ?, ?, ?, 0, 0)";
                    PreparedStatement insertCmd = connection.prepareStatement(insertCmdStr);
                    insertCmd.setInt(1, i.getId());
                    insertCmd.setInt(2, invoiceNumber);
                    insertCmd.setInt(3, line.getProductId());
                    insertCmd.setString(4, line.getProductName());
                    insertCmd.setString(5, line.getProductSKU());
                    insertCmd.setBigDecimal(6, BigDecimal.valueOf(line.getQuantity()));
                    insertCmd.executeUpdate();
                
                    String cmdTxt = "SELECT * FROM [dbo].[InvoiceLines] WHERE [InvoiceNumber] = ?";
                    InvoiceLinesService svc = new InvoiceLinesService(connection);
                    List<DbInvoiceLine> lines = svc.getInvoiceLines(cmdTxt);

                    if (lines == null || lines.size() == 0) {
                    	throw new Exception("Invoice " + id + " does not have invoice lines!");
                    }

                    if (lines.size() == 1) {
                            
                    	i.setLines(new ArrayList<>());
                        i.getLines().add(lines.get(0));

                        if (i.isUpdateable() == true) {
                        	
                        	ProductManager proMgr = new ProductManager(connection);
                            DbInvoiceLine singleLine = i.getLines().get(0);

                            List<SqlProduct> pros = new ArrayList<SqlProduct>();

                            String sqlproCmd = "SELECT * FROM [dbo].[Products] WHERE [SKU] = " + i.getLines().get(0).getSKU();
                            SqlProduct prod = proMgr.getProduct(sqlproCmd);
                            if (prod != null)
                            	pros.add(prod);

                            singleLine.setLineNumber(0);
                            singleLine.setSubtotal(this.calcSubtotal(singleLine, pros));

                            String updateCmdStr = "UPDATE [dbo].[InvoiceLines] SET [LineNumber] = ?, [Subtotal] = ? WHERE [Id] = " + id;
                            PreparedStatement cmd = connection.prepareStatement(updateCmdStr);
                            cmd.setInt(1, singleLine.getLineNumber());
                            cmd.setBigDecimal(2, singleLine.getSubtotal());
                            cmd.setInt(3, singleLine.getInvoiceLineId());
                            cmd.executeUpdate();
                        }
                    } else {
                    	
                    	i.setLines(new ArrayList<>());
                    	
                        for (DbInvoiceLine l : lines) {
                        	i.getLines().add(l);
                        }

                        if (!i.isUpdateable() == false) {
                                
                        	ProductManager proMgr = new ProductManager(connection);

                            List<SqlProduct> pros = new ArrayList<>();

                            for (DbInvoiceLine x : i.getLines()) {
                            
                            	String sqlproCmd = "SELECT * FROM [dbo].[Products] WHERE [SKU] = " + x.getSKU();
                                SqlProduct pro = proMgr.getProduct(sqlproCmd);
                                if (pro != null)
                                	pros.add(pro);
                            }

                            // TODO: Change the code so that line numbers start with 1 rather than 0.
                            // How can we write a unit test for that?
                    	    int lineNumber = 0;
                    	    
                    	    for (DbInvoiceLine lx : i.getLines()) {
                    	    	
                    	        lx.setLineNumber(lineNumber++);
                    	        lx.setSubtotal(this.calcSubtotal(lx, pros));

                    	        String updateCmdStr = "UPDATE [dbo].[InvoiceLines] SET [LineNumber] = " + lx.getLineNumber() +
                    	                ", [Subtotal] = " + lx.getSubtotal() +
                    	                " WHERE [Id] = " + lx.getInvoiceLineId();
                    	        
                    	        PreparedStatement cmd = connection.prepareStatement(updateCmdStr);
                                cmd.executeUpdate();
                    	    }
                    	    

                    	    i.setTotal(i.getLines().stream().map(DbInvoiceLine::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add));
                    	    
                    	    if (i.isGstApplies() == true) {
                    	        i.setGstAmount(i.getTotal().multiply(i.getGstRate()));
                    	    } else {
                    	        i.setGstAmount(BigDecimal.ZERO);
                    	    }

                    	    String updateInvStr = "UPDATE [dbo].[Invoices] SET [Total] = " + i.getTotal() +
                    	            ", [GstAmount] = " + i.getGstAmount() +
                    	            " WHERE [Id] = " + i.getId();
                    	    
                	        PreparedStatement insCmd = connection.prepareStatement(updateInvStr);
                	        insCmd.executeUpdate();;
                    	}
                    }
                }
                
                return i;
        	}
        	
            throw new RuntimeException("id is blank.");
        }
        
        throw new RuntimeException("line is null.");
    }
    
    
    public static BigDecimal calcSubtotal(DbInvoiceLine line, List<SqlProduct> products) {
        SqlProduct product = products.stream()
                .filter(x -> x.getSKU().equals(line.getSKU()))
                .findFirst()
                .orElse(null);

        if (product != null)
            return new BigDecimal(line.getQuantity()).multiply(product.getUnitPrice());
        else
            return (line.getSubtotal() != null) ? line.getSubtotal() : BigDecimal.ZERO;
    }
}

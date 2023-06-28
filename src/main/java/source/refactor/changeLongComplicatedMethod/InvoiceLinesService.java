package source.refactor.changeLongComplicatedMethod;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class InvoiceLinesService {
    private Connection connection;

    public InvoiceLinesService(Connection connection) {
        this.connection = connection;
    }

    public List<DbInvoiceLine> getInvoiceLines(String cmdTxt) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(cmdTxt);

        try {
            List<DbInvoiceLine> lines = new ArrayList<>();
            while (rs.next()) {
                int lId = rs.getInt("Id");
                int invoiceNo = rs.getInt("InvoiceNumber");
                int pId = rs.getInt("ProductId");
                String pName = rs.getString("ProductName");
                int quantity = rs.getInt("Quantity");
                String pSKU = rs.getString("ProductSKU");
                int lineNo = rs.getInt("LineNumber");
                BigDecimal subtotal = rs.getBigDecimal("Subtotal");

                DbInvoiceLine line = new DbInvoiceLine();
                line.setInvoiceLineId(lId);
                line.setInvoiceNumber(invoiceNo);
                line.setProductId(pId);
                line.setQuantity(quantity);
                line.setProductName(pName != null ? pName.trim() : null);
                line.setSKU(pSKU.trim());
                line.setSubtotal(subtotal);
                line.setLineNumber(lineNo);

                lines.add(line);
            }

            return lines;
        } finally {
            rs.close();
            stmt.close();
        }
    }
}

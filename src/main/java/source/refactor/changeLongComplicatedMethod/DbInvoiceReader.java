package source.refactor.changeLongComplicatedMethod;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbInvoiceReader {
	
    public static DbInvoice getInvoice(int invNo, Connection conn) throws SQLException {

        String sqlQuery = "SELECT * FROM [dbo].[Invoices] WHERE [InvoiceNumber] = " + invNo;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery);

        try {
            if (rs.next()) {
                DbInvoice invoice = new DbInvoice();

                invoice.setId(rs.getInt("Id"));
                invoice.setNo(rs.getInt("InvoiceNumber"));
                invoice.setTotal(rs.getBigDecimal("Total"));
                invoice.setUpdateable(rs.getBoolean("Updateable"));
                invoice.setGstAmount(rs.getBigDecimal("GstAmount"));
                invoice.setGstAmount(BigDecimal.ZERO);
                invoice.setGstApplies(rs.getBoolean("GstApplies"));

                return invoice;
            }
        } finally {
            rs.close();
            stmt.close();
        }

        return null;
    }
}

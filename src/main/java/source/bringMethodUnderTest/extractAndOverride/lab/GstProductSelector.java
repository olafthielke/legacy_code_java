package source.bringMethodUnderTest.extractAndOverride.lab;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GstProductSelector {
	
    public static BigDecimal selectGstRate(Product product) throws SQLException {
        String connString = "jdbc:sqlserver://prod.database.windows.net:1433;databaseName=ProductGST;user=username;password=password;encrypt=true;trustServerCertificate=false;loginTimeout=30;";

        BigDecimal gst = null;
        Connection conn = null;
        Statement stmt = null;

        conn = DriverManager.getConnection(connString);
        stmt = conn.createStatement();

        // ...

        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }

        return gst;
    }
}

package source.bringClassUnderTest.extractAndOverrideFactoryMethod.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlCustomerDatabase {
    public SqlCustomerDatabase(String connectionString) throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString);
        conn.setAutoCommit(true);

        // ...
    }
}

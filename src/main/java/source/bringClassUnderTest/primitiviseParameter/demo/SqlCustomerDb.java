package source.bringClassUnderTest.primitiviseParameter.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlCustomerDb {
    private String connectionString;

	public String getConnectionString() {
        return connectionString;
    }

	public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

	public Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(connectionString);
        conn.setAutoCommit(false);

        // ...

        return conn;
    }

	public Customer getCustomer(String emailAddress) {
        Customer customer = null;
        // Try and get customer from SQL database.

        // ...

        return customer;
    }
}

package source.bringClassUnderTest.primitiviseParameter.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CustomerDatabase {
    private SqlCustomerDb sqlDb;
    
    public CustomerDatabase() throws Exception {
        String connString = AppConfigManager.getConnString();
        String[] connStrings = connString.split("-");

        sqlDb = new SqlCustomerDb();
        sqlDb.setConnectionString(connStrings[0]);

        Connection conn = sqlDb.connect();

        // ...
    }

    public Customer getCustomer(String emailAddress) {
        Customer customer = sqlDb.getCustomer(emailAddress);

        // ...

        return customer;
    }
}

package source.bringMethodUnderTest.extractAndOverride.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlCustomerDetailsRetriever implements CustomerDetailsRetriever {
    private static final String CONNECTION_STRING = "jdbc:sqlserver://localhost;databaseName=Customers;integratedSecurity=true";

    public CustomerDetails getCustomerDetails(String customerNumber) throws SQLException {
    	
        CustomerDetails details = new CustomerDetails();

        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        String sql = "SELECT * FROM CustomerDetails WHERE CustomerNumber = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customerNumber);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            details.setFirstName(resultSet.getString("FirstName"));
            details.setLastName(resultSet.getString("LastName"));
            details.setCustomerNumber(resultSet.getString("CustomerNumber"));
            // Set other details properties
        }

        return details;
    }
}

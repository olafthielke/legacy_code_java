package source.bringMethodUnderTest.exposePublicMethod.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerAddressGetter {
    private static final String CONNECTION_STRING = "jdbc:sqlserver://localhost;databaseName=Customers;integratedSecurity=true";

    public static Address getAddress(String customerNumber, String addressType) throws NumberFormatException, SQLException {
        Address address = new Address();

        Connection connection = DriverManager.getConnection(CONNECTION_STRING);
        String sql = "SELECT * FROM Address WHERE CustomerNumber = ? AND AddressType = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customerNumber);
        statement.setString(2, addressType);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            address.setStreetNumber(resultSet.getString("StreetNumber"));
            address.setStreetName(resultSet.getString("StreetName"));
            address.setSuburb(resultSet.getString("Suburb"));
            address.setTownOrCity(resultSet.getString("TownOrCity"));
            address.setPostCode(Integer.parseInt(resultSet.getString("PostCode")));
        }

        return address;
    }
}

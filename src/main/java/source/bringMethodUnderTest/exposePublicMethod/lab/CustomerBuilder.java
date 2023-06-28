package source.bringMethodUnderTest.exposePublicMethod.lab;

import java.sql.SQLException;

public class CustomerBuilder {
    private CustomerDetailsRetriever customerDetailsRetriever;

    public CustomerBuilder() {
        customerDetailsRetriever = new CustomerDetailsRetriever();
    }

    public Customer buildCustomer(String customerNo) throws SQLException {
        CustomerDetails details = customerDetailsRetriever.getCustomerDetails(customerNo);
        Address address = CustomerAddressGetter.getAddress(customerNo, "PRIMARY");

        Customer customer = new Customer();
        customer.setFirstName(details.getFirstName());
        customer.setLastName(details.getLastName());
        // TODO: Include set/getFullName on Customer.
        //customer.setFullName(details.getFirstName() + " " + details.getLastName());
        customer.setCustomerNumber(details.getCustomerNumber());
        customer.setLoyaltyScore(details.getLoyaltyPoints());
        customer.setAddressType("PRIMARY");
        customer.setAddress(address.getStreetNumber() + " " + address.getStreetName() + ", " +
                address.getSuburb() + ", " + address.getTownOrCity() + " " + address.getPostCode());

        return customer;
    }
}

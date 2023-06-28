package source.bringMethodUnderTest.extractAndOverride.demo;

import java.sql.SQLException;

public class CustomerBuilder {
    private CustomerDetailsRetriever customerDetailsRetriever;
    
    public CustomerBuilder() {
        this(new SqlCustomerDetailsRetriever());
    }
    
    public CustomerBuilder(CustomerDetailsRetriever customerDetailsRetriever) {
        this.customerDetailsRetriever = customerDetailsRetriever;
    }


    public Customer buildCustomer(String customerNo) throws SQLException {
        CustomerDetails details = customerDetailsRetriever.getCustomerDetails(customerNo);
        
        // TODO: We want to change the address type to "POSTAL" (also on Customer). How do we 
        // unit test that it's currently "PRIMARY"? And then change the test to verify "POSTAL"
        // and finally change the code to "POSTAL"?
        Address address = CustomerAddressGetter.getAddress(customerNo, "PRIMARY");

        Customer customer = new Customer();
        customer.setFirstName(details.getFirstName());
        customer.setLastName(details.getLastName());
        customer.setCustomerNumber(details.getCustomerNumber());
        customer.setLoyaltyScore(details.getLoyaltyPoints());
        customer.setAddressType("PRIMARY");
        customer.setAddress(address.getStreetNumber() + " " + address.getStreetName() + ", " +
                address.getSuburb() + ", " + address.getTownOrCity() + " " + address.getPostCode());

        return customer;
    }
}

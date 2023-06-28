package tests.bringMethodUnderTest.extractAndOverride.demo;

import java.sql.SQLException;

import source.bringMethodUnderTest.extractAndOverride.demo.*;

public class StubCustomerDetailsRetriever implements CustomerDetailsRetriever {

	@Override
	public CustomerDetails getCustomerDetails(String customerNumber) throws SQLException {

		// This stub returns canned customer details.
		CustomerDetails customer = new CustomerDetails();
		customer.setCustomerNumber("12345678");
		customer.setFirstName("Fred");
		customer.setLastName("Flintstone");
		customer.setLoyaltyPoints(999);
		
		return customer;
	}
}

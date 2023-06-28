package tests.bringMethodUnderTest.extractAndOverride.demo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import source.bringMethodUnderTest.extractAndOverride.demo.Customer;
import source.bringMethodUnderTest.extractAndOverride.demo.CustomerBuilder;

public class CustomerBuilderTests {

	@Test
	public void test_get_primary_address() throws SQLException {
		
		StubCustomerDetailsRetriever stubDetailsRetriever = new StubCustomerDetailsRetriever();
		CustomerBuilder builder = new CustomerBuilder(stubDetailsRetriever);
		Customer customer = builder.buildCustomer("1");
		
		assertEquals(customer.getAddressType(), "PRIMARY");
	}
}

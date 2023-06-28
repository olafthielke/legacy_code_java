package source.bringMethodUnderTest.extractAndOverride.demo;

import java.sql.SQLException;

public interface CustomerDetailsRetriever {

	public CustomerDetails getCustomerDetails(String customerNumber) throws SQLException;
}

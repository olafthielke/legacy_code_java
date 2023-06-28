package source.bringClassUnderTest.primitiviseParameter.demo;


public class CustomerService {

	private CustomerDatabase database;
	
    public CustomerService() throws Exception {
        this.database = new CustomerDatabase();
    }
}

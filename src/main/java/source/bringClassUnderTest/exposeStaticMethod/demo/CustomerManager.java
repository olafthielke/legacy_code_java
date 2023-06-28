package source.bringClassUnderTest.exposeStaticMethod.demo;

// Consumer of CustomerService
public class CustomerManager {

	private CustomerService customerSvc;
	
    public CustomerManager() {
        this.customerSvc = new CustomerService();
        
    }
    
    
    public void registerNewCustomer(Customer customer) {
    	
    	this.customerSvc.validateCustomerNumber(customer);
    	
    	// ...
    }
}

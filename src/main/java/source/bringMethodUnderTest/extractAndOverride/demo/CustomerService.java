package source.bringMethodUnderTest.extractAndOverride.demo;

//Consumer of CustomerBuilder
public class CustomerService {

	private CustomerBuilder builder;
	
 public CustomerService() {
     this.builder = new CustomerBuilder();
 }
}

package source.bringClassUnderTest.exposeStaticMethod.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerService {
	
    public CustomerService() {
        // Assume that this class is very difficult to get under test,
        // maybe because it has many concrete instantiations of other
        // services.
        // ...
        // Simulate the inability to call create an instance of this class by
        // throwing an exception:
        throw new UnsupportedOperationException();
    }

    
    public void validateCustomerNumber(Customer customer) {
    	
        if (customer != null) {
            Pattern pattern = Pattern.compile("^C[0-9]{8}$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(customer.getNumber());

            if (matcher.matches() &&
                (customer.getCategory() == CustomerCategory.REG ||
                 customer.getCategory() == CustomerCategory.LOC) &&
                customer.isManualCheckDone() &&
                !customer.isCreatedByAdmin()) {
                return;
            } else {
                throw new RuntimeException("Not a valid customer.");
            }
        }

        throw new IllegalArgumentException("client");
    }
}

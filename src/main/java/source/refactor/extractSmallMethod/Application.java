package source.refactor.extractSmallMethod;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.UUID;

public class Application {
	
    // TODO How are we going to overcome this concrete Log4j logger?
	// Introduce Setter?
    private static final Logger logger = LogManager.getLogger(Application.class);
    
    private CustomerRepository repository;
    private Level logLevel;

    public Application(CustomerRepository repository, Level logLevel) {
        this.repository = repository;
        this.logLevel = logLevel;
    }

    public Application(CustomerRepository repository) {
        this(repository, Level.DEBUG);
    }

    public Customer register(CustomerData customerData) throws Exception {
        if (customerData == null) {
            if (logLevel == Level.DEBUG) {
            	logger.debug("No customer data.");
            } else {
            	logger.error("No customer data.");
            }
            throw new RuntimeException("No customer data.");
        }

        String error = customerData.validate();
        if (error != null) {
            if (logLevel == Level.DEBUG) {
            	logger.debug(error);
            } else {
            	logger.error(error);
            }
            throw new RuntimeException(error);
        }

        if (logLevel == Level.DEBUG) {
        	logger.debug("Check whether customer already exists.");
        } else {
        	logger.error("Check whether customer already exists.");
        }

        Customer existCust = repository.getCustomer(customerData.getEmailAddress());
        if (existCust != null) {
            String msg = "Customer with email address '" + customerData.getEmailAddress() + "' already exists.";

            if (logLevel == Level.DEBUG) {
            	logger.debug(msg);
            } else {
            	logger.error(msg);
            }
            throw new RuntimeException(msg);
        }

        if (logLevel == Level.DEBUG) {
        	logger.debug("Convert data to customer.");
        } else {
        	logger.error("Convert data to customer.");
        }
        Customer customer = convert(customerData);

        if (logLevel == Level.DEBUG) {
        	logger.debug("Save customer to database");
        } else {
        	logger.error("Save customer to database");
        }
        repository.saveCustomer(customer);

        return customer;
    }

    private Customer convert(CustomerData data) {
    	
    	Customer customer = new Customer();
    	customer.setCustomerNumber(UUID.randomUUID().toString());
    	customer.setFirstName(data.getFirstName());
    	customer.setLastName(data.getLastName());
    	customer.setEmailAddress(data.getEmailAddress());
    	customer.setPhoneNumber(data.getPhoneNumber());
        
    	return customer;
    }
}

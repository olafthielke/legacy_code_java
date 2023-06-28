package source.bringClassUnderTest.parameteriseConstructor.demo;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.StorageException;

// Consumer of AnalyticsService
public class CustomerService {

	private AnalyticsService analytics;
	
    public CustomerService() throws InvalidKeyException, StorageException, URISyntaxException {
        this.analytics = new AnalyticsService();
    }
}

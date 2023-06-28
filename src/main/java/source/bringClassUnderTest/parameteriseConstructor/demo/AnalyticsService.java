package source.bringClassUnderTest.parameteriseConstructor.demo;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.StorageException;

public class AnalyticsService {
    private AnalyticsLogger logger;

    public AnalyticsLogger getLogger() {
        return logger;
    }

    public void setLogger(AnalyticsLogger logger) {
        this.logger = logger;
    }

    public AnalyticsService() throws InvalidKeyException, StorageException, URISyntaxException {
        this.logger = new AzureTableStorageAnalyticsLogger();
        this.logger.Log("Analytics service initialized.", 3);
    }
}
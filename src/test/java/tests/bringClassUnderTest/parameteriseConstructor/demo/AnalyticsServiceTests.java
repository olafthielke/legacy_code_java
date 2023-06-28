package tests.bringClassUnderTest.parameteriseConstructor.demo;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.junit.Test;

import com.microsoft.azure.storage.StorageException;

import source.bringClassUnderTest.parameteriseConstructor.demo.AnalyticsService;

public class AnalyticsServiceTests {

	@Test
	public void bring_Class_Under_Test() throws InvalidKeyException, StorageException, URISyntaxException {
		
		new AnalyticsService();
	}
}

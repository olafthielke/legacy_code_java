package tests.refactor.extractSmallMethod;

import org.junit.Test;

import org.apache.logging.log4j.Level;
import source.refactor.extractSmallMethod.Application;


public class ApplicationTests {

	@Test(expected = RuntimeException.class)
	public void log_when_no_customer_data() throws Exception {
		
		Application app = new Application(null, Level.DEBUG);
		app.register(null);
	}
}

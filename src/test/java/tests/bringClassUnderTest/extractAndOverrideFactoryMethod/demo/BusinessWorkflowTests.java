package tests.bringClassUnderTest.extractAndOverrideFactoryMethod.demo;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;

import source.bringClassUnderTest.extractAndOverrideFactoryMethod.demo.BusinessWorkflow;

public class BusinessWorkflowTests {

	@Test
	public void bring_Class_Under_Test() throws IOException, SQLException {
		
		new BusinessWorkflow();
	}
}

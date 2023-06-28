package tests.bringClassUnderTest.parameteriseConstructor.lab;

import java.sql.SQLException;

import org.junit.Test;

import source.bringClassUnderTest.parameteriseConstructor.lab.*;

public class EmployeePersistenceServiceTests {
	
    @Test
    public void bring_Class_Under_Test() throws SQLException {
        // TODO: Bring the class under test.
        new EmployeePersistenceService(AuditLevel.Medium);
    }
}
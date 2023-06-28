package source.bringClassUnderTest.parameteriseConstructor.lab;

import java.sql.SQLException;


// Consumer of EmployeePersistenceService
public class EmployeeManager {

	private EmployeePersistenceService peristenceSvc;
	
    public EmployeeManager() throws SQLException {
        this.peristenceSvc = new EmployeePersistenceService(AuditLevel.Low);
    }
}

package source.bringClassUnderTest.parameteriseConstructor.lab;

import java.sql.SQLException;

public class EmployeePersistenceService {
    private EmployeeWriter employeeWriter;
   
    public EmployeePersistenceService(AuditLevel audit) throws SQLException {
        if (audit == AuditLevel.None)
            throw new RuntimeException("No auditing");

        employeeWriter = new SqlEmployeeWriter();

        // ...
    }

    public void saveEmployee(Employee e) {
    	employeeWriter.save(e);

        // ...
    }
}

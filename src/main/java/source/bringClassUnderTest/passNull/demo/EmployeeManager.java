package source.bringClassUnderTest.passNull.demo;

import java.util.List;

public class EmployeeManager {
    private MongoDbConnector database;

    public EmployeeManager(String connString, boolean store) {
        if (!store) {
            this.database = new MongoDbConnector(connString);
        }
    }

    public int calcPayroll(List<Employee> employees) {
        int payroll = 0;

        for (int i = 0; i < employees.size(); i++) {
            payroll += employees.get(i).getSalary();
        }

        return payroll;
    }
    
    // ... more methods using the database field.
}
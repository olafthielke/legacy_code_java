package source.bringClassUnderTest.parameteriseConstructor.lab;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlEmployeeWriter implements EmployeeWriter {
    public SqlEmployeeWriter() throws SQLException {
        String connString = "jdbc:sqlserver://prod.database.windows.net:1433;database=Employees;user=your_username;password=your_password;encrypt=true;trustServerCertificate=false;loginTimeout=30;";

        Connection conn = DriverManager.getConnection(connString);
        conn.setAutoCommit(false);
    }

    public void save(Employee emp) {
        throw new UnsupportedOperationException();
    }
}

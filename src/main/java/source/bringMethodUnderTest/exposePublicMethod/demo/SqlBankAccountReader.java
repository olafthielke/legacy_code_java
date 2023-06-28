package source.bringMethodUnderTest.exposePublicMethod.demo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlBankAccountReader {
	
    private String connectionString;

    public SqlBankAccountReader(String connectionString) {
        this.connectionString = connectionString;
    }

    public BankAccount getBankAccount(String accNo) throws SQLException {
        Connection connection = null;
        PreparedStatement sqlCmd = null;
        ResultSet reader = null;

        try {
            connection = DriverManager.getConnection(connectionString);
            String sql = "SELECT * FROM [dbo].[Accounts] WHERE [AccountNumber] = ?";
            sqlCmd = connection.prepareStatement(sql);
            sqlCmd.setString(1, accNo);
            reader = sqlCmd.executeQuery();

            if (reader.next()) {
                String number = reader.getString("AccountNumber");
                String name = reader.getString("AccountName");
                BigDecimal balance = reader.getBigDecimal("Balance");

                BankAccount account = new BankAccount();
                account.setAccountNumber(number);
                account.setAccountName(name);
                account.setBalance(balance);

                return account;
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (sqlCmd != null) {
                sqlCmd.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return null;
    }
}

package source.bringMethodUnderTest.exposePublicMethod.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class SqlBankTransactionWriter {
	
    public static void saveTransaction(BankTransaction tx, String connectionString) throws SQLException {
        Connection connection = null;
        PreparedStatement saveCmd = null;

        try {
            connection = DriverManager.getConnection(connectionString);
            String sql = "INSERT INTO [dbo].[Transactions] ([AccountNumber], [Amount], [Particulars], [TransactionDate]) VALUES (?, ?, ?, ?)";
            saveCmd = connection.prepareStatement(sql);
            saveCmd.setString(1, tx.getAccountNumber());
            saveCmd.setBigDecimal(2, tx.getTransactionAmount());
            saveCmd.setString(3, tx.getDescription());
            saveCmd.setDate(4, java.sql.Date.valueOf(tx.getTransactionDate()));

            saveCmd.executeUpdate();
        } finally {
            if (saveCmd != null) {
                saveCmd.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}

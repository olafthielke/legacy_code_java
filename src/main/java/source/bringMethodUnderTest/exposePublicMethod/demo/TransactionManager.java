package source.bringMethodUnderTest.exposePublicMethod.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionManager {
	
    private String connectionString;

    public TransactionManager(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public BankTransaction create(BankTransaction transaction) throws Exception {
    	
    	// More tough dependencies to be broken...
    	
        validate(transaction);

        transaction.setTransactionDate(LocalDate.now());

        SqlBankTransactionWriter.saveTransaction(transaction, connectionString);

        // ...

        // ... Many more hard-to-break dependencies. :(

        return transaction;
    }

    
    private void validate(BankTransaction transaction) throws Exception {
    	
        if (transaction == null)
            throw new RuntimeException("Transaction is required.");
        if (transaction.getDescription() == null || transaction.getDescription().trim().isEmpty())
            throw new RuntimeException("Particulars is required.");

        // TODO: We want to validate the transaction.getTransactionAmount and if it is 0,
        // then throw a "0 is not a valid transaction amount." exception.

        SqlBankAccountReader accountReader = new SqlBankAccountReader(connectionString);
        BankAccount bankAccount = accountReader.getBankAccount(transaction.getAccountNumber());

        if (bankAccount == null)
            throw new RuntimeException(transaction.getAccountNumber() + " is not a valid account number.");     
        
        if ( bankAccount.getBalance().add(transaction.getTransactionAmount()).compareTo(BigDecimal.ZERO)  < 0)
            throw new RuntimeException("Account '" + bankAccount.getAccountNumber() + "' has insufficient funds for this transaction.");
    }
}

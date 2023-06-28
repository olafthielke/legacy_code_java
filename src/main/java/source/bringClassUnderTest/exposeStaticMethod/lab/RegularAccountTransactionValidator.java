package source.bringClassUnderTest.exposeStaticMethod.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Properties;

public class RegularAccountTransactionValidator {
	
    private BigDecimal overdraftLimit;
    private BigDecimal maximumDepositAmount;

    public RegularAccountTransactionValidator() throws IOException {
        // Assume that this class is very difficult to get under test,
        // maybe because it has many concrete instantiations of other
        // services.
        // ...
  	
    	
    	String limitsString;
        Properties properties = new Properties();
        InputStream input = new FileInputStream("config.properties");
        properties.load(input);
        limitsString = properties.getProperty("RegularAccountLimits");
        String[] limits = limitsString.split("\\|");

        overdraftLimit = new BigDecimal(limits[0]);
        maximumDepositAmount = new BigDecimal(limits[1]);

        
        // Simulate the inability to create an instance of this class by
        // throwing an exception: 
        throw new UnsupportedOperationException();
    }

    
    public boolean validate(BankTransaction tx, BankAccount acc) {
    	
        if (tx == null || acc == null)
            return false;

        if (!Objects.equals(tx.getAccountNumber(), acc.getAccountNumber()))
            return false;

        if (acc.getBalance().add(tx.getTransactionAmount()).compareTo(overdraftLimit) < 0)
            return false;

        return true;
    }
}

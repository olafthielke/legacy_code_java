package source.bringClassUnderTest.exposeStaticMethod.lab;

import java.io.IOException;

// Consumer of RegularAccountTransactionValidator
public class TransactionService {

	private RegularAccountTransactionValidator validator;
	
    public TransactionService() throws IOException {
        this.validator = new RegularAccountTransactionValidator();
    }
    
    
    public void AddNewTransaction(BankTransaction tx, BankAccount acc)
    {
    	this.validator.validate(tx, acc);
    	
    	// ...
    }
}

package source.bringMethodUnderTest.exposePublicMethod.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BankTransaction {
    private String accountNumber;
    private BigDecimal transactionAmount;
    private String description;
    private LocalDate transactionDate;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return transactionAmount.compareTo(BigDecimal.ZERO) > 0 ? "CREDIT" : "DEBIT";
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}

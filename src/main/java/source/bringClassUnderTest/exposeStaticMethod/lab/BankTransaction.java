package source.bringClassUnderTest.exposeStaticMethod.lab;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class BankTransaction {
    private String accountNumber;
    private BigDecimal transactionAmount;
    private String description;
    private LocalDateTime transactionDate;

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

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BankTransaction other = (BankTransaction) obj;
        return Objects.equals(accountNumber, other.accountNumber) &&
                Objects.equals(transactionAmount, other.transactionAmount) &&
                Objects.equals(description, other.description) &&
                Objects.equals(transactionDate, other.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, transactionAmount, description, transactionDate);
    }
}

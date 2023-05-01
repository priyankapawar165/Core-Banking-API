package core.model;

import java.math.BigDecimal;
import java.math.MathContext;

public class Transaction {
    private int transactionNumber;
    private int bankAccountId;
    private double amount;
    private String transactionType;
    private String createdDate;

    public Transaction(int transactionNumber, int accountNumber, double amount, String transactionType, String createdDate) {
        this.transactionNumber = transactionNumber;
        this.bankAccountId = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.createdDate = createdDate;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}

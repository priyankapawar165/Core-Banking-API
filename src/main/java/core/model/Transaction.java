package core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {
    private int transactionNumber;
    private int bankAccountId;
    private double amount;
    private String transactionType;
    private String createdDate;
    private int customerId;
    private String toDate;
    private String fromDate;
    public Transaction(){

    }

    public Transaction(int transactionNumber, int accountNumber, double amount, String transactionType, String createdDate) {
        this.transactionNumber = transactionNumber;
        this.bankAccountId = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.createdDate = createdDate;
    }

    public Transaction(Double amount, String transactionType, String createdDate) {
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }
}

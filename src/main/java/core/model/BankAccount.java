package core.model;

import java.math.BigDecimal;

public class BankAccount {
    private int bankAccountId;
    private Integer accountNo;
    private String accountType;
    private BigDecimal amount;
    private String createdDate;

    public BankAccount(int accountNo, String accountType, BigDecimal amount, String createdDate) {
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.amount = amount;
        this.createdDate = createdDate;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}

package core.dao;

import core.model.Transaction;

import java.math.BigDecimal;

public interface TransactionDao {
    public BigDecimal executeTransaction(Transaction transaction);
}

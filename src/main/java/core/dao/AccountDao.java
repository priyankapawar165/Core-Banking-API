package core.dao;

import core.model.Customer;
import core.model.Transaction;

import java.math.BigDecimal;

public interface AccountDao {

    public int createAccount(Customer customer);
   // public BigDecimal executeTransaction(Transaction transaction);
}

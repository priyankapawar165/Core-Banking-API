package core.dao;

import core.model.Transaction;

import java.util.List;

public interface StatementDao {
    List<Transaction> getStatementList(Transaction transaction);

}

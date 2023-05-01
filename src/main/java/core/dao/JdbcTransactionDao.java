package core.dao;

import core.exception.DaoException;
import core.model.Transaction;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class JdbcTransactionDao implements TransactionDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTransactionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public BigDecimal executeTransaction(Transaction transaction) {
        try {
            //step:1 Get Balance from bank_account table
            double balance = getBalance(transaction.getBankAccountId());

            //step:2 Update Balance in bank Table
            updateBalanceInBank(transaction.getBankAccountId(), transaction.getAmount(), transaction.getTransactionType(), balance);

            //step:3 insert balance in transaction table
            String insertTransaction = "INSERT INTO transaction(bank_account_id,amount,transaction_type,created_date) " +
                    " Values(?,?,?,?) " +
                    " RETURNING transaction_no";
            LocalDate currentDate = LocalDate.now();
            BigDecimal newTransaction = jdbcTemplate.queryForObject(insertTransaction, BigDecimal.class, transaction.getBankAccountId(), transaction.getAmount(), transaction.getTransactionType(), currentDate);
            return newTransaction;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Couldn't connect to DB", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
    }

    public double getBalance(int bankAccountId) {
        String selectTransaction = "SELECT * FROM bank_account WHERE bank_account_id=?";
        double dbBalance = 0.0;
        SqlRowSet queryResults = jdbcTemplate.queryForRowSet(selectTransaction, bankAccountId);
        if (queryResults.next()) {
            dbBalance = queryResults.getDouble("account_balance");
        }
        return dbBalance;
    }

    public int updateBalanceInBank(int bankAccountId, double amount, String transactionType, double existingBalance) {
        String updateTransaction = "UPDATE bank_account SET account_balance=? WHERE bank_account_id=?";

        double calculateBalance = 0.0;
        if (transactionType.equals("deposit")) {
            calculateBalance = existingBalance + amount;
        } else {
            calculateBalance = existingBalance - amount;

        }
        return jdbcTemplate.update(updateTransaction, calculateBalance, bankAccountId);

    }
}


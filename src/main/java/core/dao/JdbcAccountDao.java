package core.dao;

import core.exception.DaoException;
import core.model.Customer;
import core.model.Transaction;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

@Component
public class JdbcAccountDao implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createAccount(Customer customer) {
        String customerSql = "INSERT INTO customer(name,address)" +
                " VALUES(?,?)" +
                " Returning customer_id";

        String bankAccountSql = "INSERT INTO bank_account(account_type, account_no, customer_id,account_balance)" +
                " VALUES (?,?,?,?)" +
                " RETURNING bank_account_id";
        try {
            int newCustomerId = jdbcTemplate.queryForObject(customerSql, int.class, customer.getName(), customer.getAddress());

            int accountNumber = generateAccountNo();

            jdbcTemplate.queryForObject(bankAccountSql, int.class, customer.getAccountType(), accountNumber, newCustomerId, 0);

            return accountNumber;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Couldn't connect to DB", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
    }

  /*  @Override
    public BigDecimal executeTransaction(Transaction transaction) {
        String sql = "INSERT INTO transaction(bank_account_id,amount,transaction_type,created_date) " +
                " Values(?,?,?,?) " +
                " RETURNING transaction_no";
        String sql1 = "SELECT * FROM bank_account WHERE bank_account_id=? ";
        String sql2 = "UPDATE bank_account SET account_balance=? WHERE  bank_account_id=?";
        try {
            BigDecimal dbBalance = new BigDecimal(0.0);
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql1, transaction.getBankAccountId());
            if (queryResults.next()) {
                dbBalance = queryResults.getBigDecimal("account_balance");
            }

            if (transaction.getTransactionType().equals("deposit")) {
                BigDecimal calculateBalance = dbBalance.add(transaction.getAmount());
                jdbcTemplate.update(sql2, calculateBalance, transaction.getBankAccountId());
            }

            LocalDate currentDate = LocalDate.now();
            BigDecimal newTransactionNo = jdbcTemplate.queryForObject(sql, BigDecimal.class, transaction.getBankAccountId(), transaction.getAmount(), transaction.getTransactionType(), currentDate);
            return newTransactionNo;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Couldn't connect to DB", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }

    }*/

    private int generateAccountNo() {
        Random rand = new Random();
        int accountNumber = rand.nextInt(1000000000);
        return accountNumber;
    }
}

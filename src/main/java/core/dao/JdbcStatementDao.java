package core.dao;

import core.exception.DaoException;
import core.model.Transaction;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStatementDao implements StatementDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcStatementDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Transaction> getStatementList(Transaction transaction) {
        List<Transaction> transactionList = new ArrayList<>();
        String sql = "  SELECT * FROM transaction t " +
                " JOIN bank_account b ON b.bank_account_id = t.bank_account_id " +
                " JOIN customer c ON c.customer_id = b.customer_id " +
                " WHERE c.customer_id = ? AND t.created_date >= ?  AND t.created_date <= ? ";
        try {
            LocalDate fromDate = LocalDate.parse(transaction.getFromDate());
            LocalDate toDate = LocalDate.parse(transaction.getToDate());
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transaction.getCustomerId(), fromDate, toDate);

            while (results.next()) {
                Transaction t = new Transaction(results.getDouble("amount"), results.getString("transaction_type"), results.getString("created_date"));
                transactionList.add(t);
            }
            return transactionList;

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Couldn't connect to DB", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
    }
}


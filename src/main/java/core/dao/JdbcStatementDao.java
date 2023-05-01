package core.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcStatementDao implements StatementDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcStatementDao (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}

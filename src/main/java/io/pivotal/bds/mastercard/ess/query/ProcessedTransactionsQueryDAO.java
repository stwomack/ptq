package io.pivotal.bds.mastercard.ess.query;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class ProcessedTransactionsQueryDAO {
    JdbcTemplate jdbcTemplate;

    public Map baseQuery(String custom) {
        return jdbcTemplate.queryForMap("select firstName, lastName from people");
    }
}

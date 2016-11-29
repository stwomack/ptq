package io.pivotal.bds.mastercard.ess.query.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProcessedTransactionsQueryDAO {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${processesed.transaction.query}")
    private String processedTransactionsQuery;

    public List queryByCustomer(String custClstrId, String startDate, String endDate, Long limit) {
        System.err.println(processedTransactionsQuery);
        Map namedParameters = new HashMap();
        namedParameters.put("custClstrId", custClstrId);
        namedParameters.put("startDate", startDate);
        namedParameters.put("endDate", endDate);
        namedParameters.put("limit", limit);
        return namedParameterJdbcTemplate.queryForList(processedTransactionsQuery, namedParameters).subList(0,3);
    }

    public List queryByCustomerTest(String lastName) {
        Map namedParameters = new HashMap();
        namedParameters.put("lastName", lastName);
        return namedParameterJdbcTemplate.queryForList("select * from people where lastName = :lastName", namedParameters);
    }
}

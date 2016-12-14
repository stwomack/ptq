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
        System.out.println(processedTransactionsQuery);
        Map namedParameters = new HashMap();
        namedParameters.put("custClstrId", custClstrId);
        namedParameters.put("startDate", startDate);
        namedParameters.put("endDate", endDate);
        namedParameters.put("limit", limit);
        List results = namedParameterJdbcTemplate.queryForList(processedTransactionsQuery, namedParameters);
        Map<String, String> count = new HashMap<>();
        count.put("Count: ", new Integer(results.size()).toString());
        results.add(0, count);
        System.err.println(results);
        if (results.size() > 2) {
            return results.subList(0,2);
        } else {
            return results;
        }
    }

    public List queryByCustomerTest(String lastName) {
        Map namedParameters = new HashMap();
        namedParameters.put("lastName", lastName);
        return namedParameterJdbcTemplate.queryForList("select * from people where lastName = :lastName", namedParameters);
    }
}

package io.pivotal.bds.mastercard.ess.query.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProcessedTransactionsQueryDAO {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${processesed.transaction.query}")
    private String processedTransactionsQuery;

//    public List queryByCustomer(String custClstrId, String startDate, String endDate, Long limit) {
//        System.out.println(processedTransactionsQuery);
//        Map namedParameters = new HashMap();
//        namedParameters.put("custClstrId", custClstrId);
//        namedParameters.put("startDate", startDate);
//        namedParameters.put("endDate", endDate);
//        namedParameters.put("limit", limit);
//        return namedParameterJdbcTemplate.queryForList(processedTransactionsQuery, namedParameters).subList(0,1);
//    }

    public List queryByCustomer(String custClstrId, String startDate, String endDate, Long limit) {
        Map namedParameters = new HashMap();
        namedParameters.put("custClstrId", custClstrId);
        namedParameters.put("startDate", startDate);
        namedParameters.put("endDate", endDate);
        namedParameters.put("limit", limit);
        Date startTime = new Date();
        System.err.println("Query Start: " + startTime + "***");
        List results = namedParameterJdbcTemplate.queryForList(processedTransactionsQuery, namedParameters);
        Date endTime = new Date();
        System.err.println("Query End: " + endTime + "***");
        long timeDiff = getDateDiff(startTime,endTime);
        System.err.println("Query Total Time (in Seconds): " + timeDiff + "***");
        Map<String, String> count = new HashMap<>();
        int size = results.size();
        count.put("Count: ", new Integer(size).toString());
        results.add(0, count);
        if (size > 2) {
            return results.subList(0,2);
        } else {
            return results;
        }
    }

    private static long getDateDiff(Date date1, Date date2) {
        return (date2.getTime()-date1.getTime())/1000;
    }


    public List queryByCustomerTest(String lastName) {
        Map namedParameters = new HashMap();
        namedParameters.put("lastName", lastName);
        return namedParameterJdbcTemplate.queryForList("select * from people where lastName = :lastName", namedParameters);
    }
}

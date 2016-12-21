package io.pivotal.bds.mastercard.ess.query.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import scala.Int;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ProcessedTransactionsQueryDAO {
    Integer rowCount = new Integer(0);

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${processesed.transaction.query}")
    private String processedTransactionsQuery;

    public List queryByCustomer(String custClstrId, String startDate, String endDate, Long limit) {
        Map namedParameters = new HashMap();
        namedParameters.put("custClstrId", custClstrId);
        namedParameters.put("startDate", startDate);
        namedParameters.put("endDate", endDate);
        namedParameters.put("limit", limit);
        Date startTime = new Date();
        System.err.println("Query Start: " + startTime + "***");
        List results = new ArrayList();
        rowCount = 0;
        RowCallbackHandler rowCallbackHandler = new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                rowCount++;
            }
        };
        namedParameterJdbcTemplate.query(processedTransactionsQuery, namedParameters, rowCallbackHandler);
        Date endTime = new Date();
        System.err.println("Query End: " + endTime + "***");
        long timeDiff = getDateDiff(startTime,endTime);
        System.err.println("Query Total Time (in Seconds): " + timeDiff + "***");
        Map<String, String> countMap = new HashMap<>();
        countMap.put("Count: ", rowCount.toString());
        results.add(0, countMap);
        return results;
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

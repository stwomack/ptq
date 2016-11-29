package io.pivotal.bds.mastercard.ess.query.service;

import io.pivotal.bds.mastercard.ess.query.dao.ProcessedTransactionsQueryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessedTransactionsQueryService {
    List list;

    @Autowired
    ProcessedTransactionsQueryDAO processedTransactionsQueryDAO;

    public List queryByCustomer(String custClstrId, String startDate, String endDate, Long limit) {
        list = processedTransactionsQueryDAO.queryByCustomer(custClstrId, startDate, endDate, limit);
        return list;
    }

    public List queryByCustomerTest(String lastName) {
        return processedTransactionsQueryDAO.queryByCustomerTest(lastName);
    }
}

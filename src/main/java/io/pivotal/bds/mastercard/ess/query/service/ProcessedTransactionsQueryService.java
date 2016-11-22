package io.pivotal.bds.mastercard.ess.query.service;

import io.pivotal.bds.mastercard.ess.query.ProcessedTransactionsQueryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessedTransactionsQueryService {

    @Autowired
    ProcessedTransactionsQueryDAO processedTransactionsQueryDAO;

    public List queryByCustomer(String startDate, String endDate) {
        return processedTransactionsQueryDAO.queryByCustomer(startDate, endDate);
    }

    public List queryByCustomerTest(String lastName) {
        return processedTransactionsQueryDAO.queryByCustomerTest(lastName);
    }
}

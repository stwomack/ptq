package io.pivotal.bds.mastercard.ess.query.service;

import io.pivotal.bds.mastercard.ess.query.ProcessedTransactionsQueryDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ProcessedTransactionsQueryService {

    @Autowired
    ProcessedTransactionsQueryDAO processedTransactionsQueryDAO;

    public Map queryByCustomer(String custClstrId) {
        return processedTransactionsQueryDAO.queryByCustomer(custClstrId);
    }

    public Map queryByCustomerTest(String custClstrId) {
        return processedTransactionsQueryDAO.queryByCustomerTest(custClstrId);
    }
}

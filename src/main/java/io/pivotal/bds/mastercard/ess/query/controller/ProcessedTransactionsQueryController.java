package io.pivotal.bds.mastercard.ess.query.controller;

import io.pivotal.bds.mastercard.ess.query.service.ProcessedTransactionsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ProcessedTransactionsQueryController {
    @Autowired
    ProcessedTransactionsQueryService processedTransactionsQueryService;

    @RequestMapping(value = "/processedTransactions/{custClstrId}", method = RequestMethod.GET)
    public
    @ResponseBody
    List queryByCustomer(@PathVariable("custClstrId") String custClstrId, @RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate) {
        Date startTime = new Date();
        System.err.println("Start: " + startTime);
        List results = new ArrayList();
        results.add("Start: " + startTime);
        results.add(processedTransactionsQueryService.queryByCustomer("01/01/2016 00:00:00", "12/29/2016 01:01:01"));
        Date endTime = new Date();
        results.add("End: " + endTime);
        System.err.println("End: " + endTime);
        return results;
//        return processedTransactionsQueryService.queryByCustomerTest("Womack");
    }

}

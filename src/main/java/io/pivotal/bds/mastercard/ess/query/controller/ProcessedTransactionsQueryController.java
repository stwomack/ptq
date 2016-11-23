package io.pivotal.bds.mastercard.ess.query.controller;

import io.pivotal.bds.mastercard.ess.query.service.ProcessedTransactionsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProcessedTransactionsQueryController {
    @Autowired
    ProcessedTransactionsQueryService processedTransactionsQueryService;

    @RequestMapping(value = "/processedTransactions/{custClstrId}", method = RequestMethod.GET)
    public
    @ResponseBody
    List queryByCustomer(@PathVariable("custClstrId") String custClstrId, @RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate) {
        return processedTransactionsQueryService.queryByCustomer("01/01/2016 01:01:01", "12/29/2016 01:01:01");
//        return processedTransactionsQueryService.queryByCustomerTest("Womack");
    }

}

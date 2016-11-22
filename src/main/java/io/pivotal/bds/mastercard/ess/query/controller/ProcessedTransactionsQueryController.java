package io.pivotal.bds.mastercard.ess.query.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProcessedTransactionsQueryController {
    @RequestMapping(value = "/processedTransactions/{custClstrId}", method = RequestMethod.GET)
    public
    @ResponseBody
    Map searchWithSearchTerm(@PathVariable("custClstrId") String custClstrId) {
        return null;
    }

}

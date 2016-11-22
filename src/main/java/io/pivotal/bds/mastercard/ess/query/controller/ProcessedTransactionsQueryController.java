package io.pivotal.bds.mastercard.ess.query.controller;

import io.pivotal.bds.mastercard.ess.query.domain.AuthorizationRequest;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class ProcessedTransactionsQueryController {
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/authorizationRequest/old", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    AuthorizationRequest authorizationRequest(
            @RequestBody AuthorizationRequest authorizationRequest) throws ExecutionException, InterruptedException, IOException {

        String message = mapper.writeValueAsString(authorizationRequest);
        System.out.println(String.format("Payment put on queue = [%s]", message));

        return authorizationRequest;
    }
}

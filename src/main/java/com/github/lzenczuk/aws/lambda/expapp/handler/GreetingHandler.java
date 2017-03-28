package com.github.lzenczuk.aws.lambda.expapp.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.github.lzenczuk.aws.lambda.expapp.handler.model.CreateTransactionRequest;
import com.github.lzenczuk.aws.lambda.expapp.handler.model.CreateTransactionResponse;
import com.github.lzenczuk.aws.lambda.expapp.handler.model.TransactionStatus;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

/**
 * Created by lzenczuk on 27/03/17.
 */
public class GreetingHandler {

    private static final Logger log = Logger.getLogger(GreetingHandler.class);

    public String hello(String name, Context context){
        log.info("Handling hello request. Name: "+name);

        if(name==null){
            return "Hello stranger!";
        }

        return "Hello "+name+"!";
    }

    public CreateTransactionResponse makeTransaction(CreateTransactionRequest request, Context context){
        log.info("Handling create transaction request: "+request);

        CreateTransactionResponse response = new CreateTransactionResponse();

        if(request==null){
            response.addError("Null create transaction request.");
        }else {

            if (request.getSourceAccountId() == null) {
                response.addError("Source account id can't be null.");
            }

            if (request.getTargetAccountId() == null) {
                response.addError("Target account id can't be null.");
            }

            BigDecimal amount;
            try {
                amount = new BigDecimal(request.getAmount());
                if (amount.compareTo(BigDecimal.ZERO) != 1) {
                    response.addError("Amount have to be bigger then 0.");
                } else {
                    log.info("Sending " + amount + " from " + request.getSourceAccountId() + " to " + request.getTargetAccountId());
                    response.setStatus(TransactionStatus.SUCCESS);
                    response.setTransactionId(new Double(Math.random() * 1000000).longValue());
                    return response;
                }
            } catch (NumberFormatException e) {
                response.addError("Amount have to be decimal value");
            }
        }

        response.setStatus(TransactionStatus.FAILURE);
        return response;

    }
}

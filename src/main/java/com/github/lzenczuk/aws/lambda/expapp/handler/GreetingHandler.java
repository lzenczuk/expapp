package com.github.lzenczuk.aws.lambda.expapp.handler;

import com.amazonaws.services.lambda.runtime.Context;
import org.apache.log4j.Logger;

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
}

package com.github.lzenczuk.aws.lambda.expapp.handler;

import com.amazonaws.services.lambda.runtime.Context;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by lzenczuk on 27/03/17.
 */
public class GreetingHandlerTest {

    private static final Logger log = Logger.getLogger(GreetingHandlerTest.class);

    @Test
    public void helloHandlerShouldReturnHelloMessageWithName(){
        GreetingHandler greetingHandler = new GreetingHandler();

        Context mockContext = mock(Context.class);

        String message = greetingHandler.hello("Tom", mockContext);
        assertEquals("Hello Tom!", message);
    }

    @Test
    public void helloHandlerShouldReturnHelloMessageWhenNameIsNotProvide(){
        GreetingHandler greetingHandler = new GreetingHandler();

        Context mockContext = mock(Context.class);

        String message = greetingHandler.hello(null, mockContext);
        assertEquals("Hello stranger!", message);
    }
}

package com.Workit.Workit.Logging;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect

public class LoggingAspect {
    public static void logit(){
        LOGGER.info("getAllPost Called");
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution ( * com.Workit.workit.controller.PostController.getAllPost())")
    public void log(){
        LOGGER.info("getAllPost Called");
    }
    @After("execution ( * com.Workit.workit.controller.PostController.getAllPost())")
    public void log2(){
        LOGGER.info("getAllPost Called n done");
    }
}

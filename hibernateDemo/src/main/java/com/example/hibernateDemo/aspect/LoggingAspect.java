package com.example.hibernateDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {


    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type , class name.method-name(args)
    @Before("execution(* com.example.hibernateDemo.service.StudentService.*(..))")
    public void beforeLoggingAspect(JoinPoint joinPoint) {
        LOGGER.info("The method was started :: "+joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.hibernateDemo.service.StudentService.*(..))")
    public void afterLoggingAspect(JoinPoint joinPoint) {
        LOGGER.info("The method was ended :: "+joinPoint.getSignature().getName());
    }
}

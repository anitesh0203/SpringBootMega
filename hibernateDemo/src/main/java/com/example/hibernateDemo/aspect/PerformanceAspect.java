package com.example.hibernateDemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class PerformanceAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    // return type , class name.method-name(args)

    @Around("execution(* com.example.hibernateDemo.service.*.*(..))")
    public Object performanceAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long totalTime = end - start;
        LOGGER.info("The time taken by ::"+ proceedingJoinPoint.getSignature().getName()+" :: time taken "+ totalTime);
        return obj;
    }
}

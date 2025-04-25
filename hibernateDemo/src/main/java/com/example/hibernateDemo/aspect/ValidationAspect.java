package com.example.hibernateDemo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    @Around("execution( * com.example.hibernateDemo.service.*.*(..)))")
    public Object validationAspect(ProceedingJoinPoint pj) throws Throwable {
        Object obj = pj.proceed();
        return obj;
    }
}

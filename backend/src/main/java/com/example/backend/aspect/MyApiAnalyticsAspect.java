package com.example.backend.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2) // Lower precedence, runs after MyDemoLoggingAspect
public class MyApiAnalyticsAspect {

    @Before("execution(* com.example.backend.dao.*.*(..))")
    public void performApiAnalytics() {
        System.out.println("\n====> Performing API analytics");
    }
}

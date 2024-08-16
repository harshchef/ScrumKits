package com.example.backend.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3) // Lowest precedence, runs after other aspects
public class MySecurityAspect {

    @Before("execution(* com.example.backend.dao.*.*(..))")
    public void performSecurityCheck() {
        System.out.println("\n====> Performing security check");
    }
}

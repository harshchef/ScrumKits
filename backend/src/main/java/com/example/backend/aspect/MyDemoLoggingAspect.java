// package com.example.backend.aspect;

// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.springframework.stereotype.Component;

// @Aspect
// @Component
// public class MyDemoLoggingAspect {

//     // @Before("execution(public void addAccount())")
//     // @Before("execution(public void com.example.backend.dao.AccountDAOImpl.addAccount())")
//     @Pointcut("execution(public void add*(com.example.backend.Account))")
//     private void forDAOPackage(){}
    

//     @Pointcut("execution(public void add*(com.example.backend.Account,..))")
//     private void forDAOPackagenoGetterNoSetter(){}


//     @Before("forDAOPackage()")
//     public void beforeAddAccountAdvice()
//     {
//         System.out.println("\n ====> eXECUTING BEFORE ADDACCOUNT");
//     }
// }


// package com.example.backend.aspect;

// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;

// @Aspect
// @Order(1)
// @Component
// public class MyDemoLoggingAspect {

//     // Pointcut for methods starting with "add" in the DAO package
//     @Pointcut("execution(* com.example.backend.dao.*.add*(..))")
//     private void forDAOPackage() {}

//     // Pointcut for excluding getter methods
//     @Pointcut("execution(* com.example.backend.dao.*.get*(..))")
//     private void getter() {}

//     // Pointcut for excluding setter methods
//     @Pointcut("execution(* com.example.backend.dao.*.set*(..))")
//     private void setter() {}

//     // Combined pointcut: include DAO package methods that start with "add", excluding getters and setters
//     @Pointcut("forDAOPackage() && !(getter() || setter())")
//     private void forDAOPackageNoGetterSetter() {}

//     // Advice to run before any method matching the combined pointcut
//     @Before("forDAOPackageNoGetterSetter()")
//     public void beforeAddAccountAdvice() {
//         System.out.println("\n====> Executing @Before advice on addAccount()");
//     }
// }


// package com.example.backend.aspect;

// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;

// @Aspect
// @Component
// @Order(1) // Highest precedence
// public class MyDemoLoggingAspect {

//     @Pointcut("execution(* com.example.backend.dao.*.add*(..))")
//     private void forDAOPackage() {}

//     @Pointcut("execution(* com.example.backend.dao.*.get*(..))")
//     private void getter() {}

//     @Pointcut("execution(* com.example.backend.dao.*.set*(..))")
//     private void setter() {}

//     @Pointcut("forDAOPackage() && !(getter() || setter())")
//     private void forDAOPackageNoGetterSetter() {}

//     @Before("forDAOPackageNoGetterSetter()")
//     public void beforeAddAccountAdvice() {
//         System.out.println("\n====> Executing @Before advice on addAccount()");
//     }
// }


// package com.example.backend.aspect;

// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.AfterReturning;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;

// @Aspect
// @Component
// @Order(1) // Highest precedence
// public class MyDemoLoggingAspect {

//     @Pointcut("execution(* com.example.backend.dao.*.add*(..))")
//     private void forDAOPackage() {}

//     @Pointcut("execution(* com.example.backend.dao.*.get*(..))")
//     private void getter() {}

//     @Pointcut("execution(* com.example.backend.dao.*.set*(..))")
//     private void setter() {}

//     @Pointcut("forDAOPackage() && !(getter() || setter())")
//     private void forDAOPackageNoGetterSetter() {}

//     @Before("forDAOPackageNoGetterSetter()")
//     public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
//         // Display the method signature
//         String methodSignature = theJoinPoint.getSignature().toString();
//         System.out.println("\n====> Executing @Before advice on method: " + methodSignature);

//         // Display the method arguments
//         Object[] args = theJoinPoint.getArgs();
//         for (Object arg : args) {
//             System.out.println("====> Argument: " + arg);

//             // If the argument is of type Account, you can access its properties
//             if (arg instanceof com.example.backend.Account) {
//                 com.example.backend.Account account = (com.example.backend.Account) arg;
//                 System.out.println("====> Account Details: " + account);
//             }
//         }


//     }
//     @AfterReturning
//     public void AfterReturning(returning,pointcut)
// }


// package com.example.backend.aspect;

// import java.util.List;

// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.AfterReturning;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;

// @Aspect
// @Component
// @Order(1) // Highest precedence
// public class MyDemoLoggingAspect {

//     @Pointcut("execution(* com.example.backend.dao.*.add*(..))")
//     private void forDAOPackage() {}

//     @Pointcut("execution(* com.example.backend.dao.*.get*(..))")
//     private void getter() {}

//     @Pointcut("execution(* com.example.backend.dao.*.set*(..))")
//     private void setter() {}

//     @Pointcut("forDAOPackage() && !(getter() || setter())")
//     private void forDAOPackageNoGetterSetter() {}

//     @Before("forDAOPackageNoGetterSetter()")
//     public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
//         // Display the method signature
//         String methodSignature = theJoinPoint.getSignature().toString();
//         System.out.println("\n====> Executing @Before advice on method: " + methodSignature);

//         // Display the method arguments
//         Object[] args = theJoinPoint.getArgs();
//         for (Object arg : args) {
//             System.out.println("====> Argument: " + arg);

//             // If the argument is of type Account, you can access its properties
//             if (arg instanceof com.example.backend.Account) {
//                 com.example.backend.Account account = (com.example.backend.Account) arg;
//                 System.out.println("====> Account Details: " + account);
//             }
//         }
//     }

//     @AfterReturning(
//         pointcut = "execution(* com.example.backend.dao.AccountDAO.findAccounts(..))",
//         returning = "result"
//     )
//     public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<com.example.backend.Account> result) {
//         // Display the method signature
//         String methodSignature = theJoinPoint.getSignature().toString();
//         System.out.println("\n====> Executing @AfterReturning advice on method: " + methodSignature);

//         // Display the results of the method call
//         System.out.println("====> Result: " + result);

//         // Optionally modify the result
//         if (!result.isEmpty()) {
//             com.example.backend.Account firstAccount = result.get(0);
//             firstAccount.setName("DUMMY_NAME");
//             System.out.println("====> Modified first account's name to: " + firstAccount.getName());
//         }
//     }
// }


package com.example.backend.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.backend.Account;

import java.util.List;

@Aspect
@Component
@Order(1) // Highest precedence
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.example.backend.dao.*.add*(..))")
    private void forDAOPackage() {}

    @Pointcut("execution(* com.example.backend.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.example.backend.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    private void forDAOPackageNoGetterSetter() {}

    @Before("forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        // Display the method signature
        String methodSignature = theJoinPoint.getSignature().toString();
        System.out.println("\n====> Executing @Before advice on method: " + methodSignature);

        // Display the method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("====> Argument: " + arg);

            // If the argument is of type Account, you can access its properties
            if (arg instanceof Account) {
                com.example.backend.Account account = (com.example.backend.Account) arg;
                System.out.println("====> Account Details: " + account);
            }
        }
    }

    @AfterReturning(
        pointcut = "execution(* com.example.backend.dao.AccountDAO.findAccounts(..))",
        returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<com.example.backend.Account> result) {
        // Display the method signature
        String methodSignature = theJoinPoint.getSignature().toString();
        System.out.println("\n====> Executing @AfterReturning advice on method: " + methodSignature);

        // Display the results of the method call
        System.out.println("====> Result: " + result);

        // Optionally modify the result
        if (!result.isEmpty()) {
            com.example.backend.Account firstAccount = result.get(0);
            firstAccount.setName("DUMMY_NAME");
            System.out.println("====> Modified first account's name to: " + firstAccount.getName());
        }
    }

    @Around("execution(* com.example.backend.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        // Display method signature
        String method = theProceedingJoinPoint.getSignature().toString();
        System.out.println("\n====> Executing @Around advice on method: " + method);

        // Get begin timestamp
        long begin = System.currentTimeMillis();

        // Proceed with the target method execution
        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("====> Exception caught: " + e.getMessage());

            // Optionally rethrow the exception
            throw e;
        }

        // Get end timestamp
        long end = System.currentTimeMillis();

        // Compute duration and display it
        long duration = end - begin;
        System.out.println("====> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }
}

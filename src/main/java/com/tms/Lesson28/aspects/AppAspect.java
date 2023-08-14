package com.tms.Lesson28.aspects;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Aspect
public class AppAspect {

    @Pointcut("@annotation(com.tms.Lesson28.aspects.Loggable)")
    public void findLoggable(){}

    @Around("findLoggable()")
    public void loggable(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Start aspect on method at " + currentTime);
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = String.valueOf(methodSignature.getMethod());
        long endTime = System.currentTimeMillis();
        System.out.println("\nAspect ended on " + methodName + " after " + (endTime - startTime) + " mils");
    }
}

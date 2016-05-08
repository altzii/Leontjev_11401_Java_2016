package ru.kpfu.itis.leontjev.warranty_department.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Alexander on 08/05/2016.
 */
@Aspect
public class LogAspect {
    private final static Logger logger = Logger.getLogger(LogAspect.class);

    @Before("execution(* ru.kpfu.itis.leontjev.warranty_department.service.*.*(..))")
    public void logMethodInvocationInService(JoinPoint joinPoint) {
        logger.info(new Date()
                + " Start invocation of service method"
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params:\n"
                + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("execution(* ru.kpfu.itis.leontjev.warranty_department.service.*.*(..))")
    public Object logToInfoTimeService(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object method = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long result = end - start;
        logger.info("End invocation of service method: " + result + "ms");
        return method;
    }
}

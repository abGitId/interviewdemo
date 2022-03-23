package com.example.interviewdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Slf4j
public class MethodExecutionTimeAspect {

    @Around(value = "@annotation(com.example.interviewdemo.aop.TrackTime)")
  public void getMethodExecutionTime(ProceedingJoinPoint joinPoint) {
    long startTime = System.currentTimeMillis();

    try {
      joinPoint.proceed();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    }

    long timeTaken = System.currentTimeMillis() - startTime;
    log.info("Time Taken by {} is {}", joinPoint, timeTaken);
  }
}

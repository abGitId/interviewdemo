package com.example.interviewdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
  // -- @Before("execution(* *.*interviewdemo(..))")
  // -- @Before(value = "execution(* com.javainuse.service.EmployeeService.*(..)) and
  // args(name,empId)")
  @Before(value = "within(com.example.interviewdemo..*)")
  public void before(JoinPoint joinPoint) {
    log.info("Entering method:{}", joinPoint.getSignature());
//    System.out.println("joinPoint.toString() = " + joinPoint.toString());
//    System.out.println("joinPoint.getKind() = " + joinPoint.getKind());
//    System.out.println("joinPoint.getArgs() = " + joinPoint.getArgs());
//    System.out.println("joinPoint.toShortString() = " + joinPoint.toShortString());
//    System.out.println("joinPoint.toLongString() = " + joinPoint.toLongString());
//    System.out.println("joinPoint.getSourceLocation() = " + joinPoint.getSourceLocation());
//    System.out.println(
//        "joinPoint.getStaticPart().getSignature() = " + joinPoint.getStaticPart().getSignature());
  }

  @After(value = "within(com.example.interviewdemo..*)")
  public void after(JoinPoint joinPoint) {
    log.info("Exiting method:{}", joinPoint.getSignature());
  }
}

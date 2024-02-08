package com.pp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
  private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

  //return type, className.methodName(args)
  @Before("execution(* com.pp.service.CustomerServiceImpl.deleteCx(..)) || execution(* com.pp.service.CustomerServiceImpl.getCustomers(..))")
 public void logMethodCall(JoinPoint jp) {
	 LOGGER.info("method called "+jp.getSignature().getName());
 }
  
  //return type, className.methodName(args)
 // It runs when a matched method execution exits. 
  @After("execution(* com.pp.service.CustomerServiceImpl.deleteCx(..)) || execution(* com.pp.service.CustomerServiceImpl.getCustomers(..))")
 public void logMethodExecuted(JoinPoint jp) {
	 LOGGER.info("method executed at last : "+jp.getSignature().getName());
 }
  
  //return type, className.methodName(args)
  @AfterThrowing("execution(* com.pp.service.CustomerServiceImpl.deleteCx(..)) || execution(* com.pp.service.CustomerServiceImpl.getCustomers(..))")
 public void logMethodCrashed(JoinPoint jp) {
	 LOGGER.info("method got exception : "+jp.getSignature().getName());
 }
  
  //return type, className.methodName(args)
  //It runs when a matched method execution returns a value normally
  @AfterReturning("execution(* com.pp.service.CustomerServiceImpl.deleteCx(..)) || execution(* com.pp.service.CustomerServiceImpl.getCustomers(..))")
 public void logMethodReturnedSuccessfully(JoinPoint jp) {
	 LOGGER.info("method Executed Successfully : "+jp.getSignature().getName());
 }

}

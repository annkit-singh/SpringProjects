package com.in10minutes.basic.springaopin10steps.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterUserAccessAspect {
	Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@AfterReturning(value="com.in10minutes.basic.springaopin10steps.aspect.CommonJointPointConfig.dataServices()",returning="result")  //for all classes in the package springaopin10steps
	public void afterReturning(JoinPoint joinPoint,Object result) {
		logger.info("Performing after returning  functions ");
		logger.info("We are at method {} and returning result is  ======={}",joinPoint,result);
	}
	
	/*
	@AfterThrowing(value="execution(* com.in10minutes.basic.springaopin10steps.data.*.*(..))",throwing="exception")  //for all classes in the package springaopin10steps
	public void afterThrowing(JoinPoint joinPoint,Object exception) {
		int n=10/0;
		logger.info("Performing after throwing  functions ");
		logger.info("We are at method {} and throwing result is  ======={}",joinPoint,exception);
	}
	

	@After("execution(* com.in10minutes.basic.springaopin10steps.data.*.*(..))")  //for all classes in the package springaopin10steps
	public void after(JoinPoint joinPoint) {
		logger.info("Performing after functions ");
		logger.info("We are at method {}",joinPoint);
	}
	*/

	
	
}

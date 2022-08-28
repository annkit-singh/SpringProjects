package com.in10minutes.basic.springaopin10steps.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundUserAccessAspect {
	Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Around(value="com.in10minutes.basic.springaopin10steps.aspect.CommonJointPointConfig.trackTimeAnnot()")  //for all classes in the package springaopin10steps
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		long current=	System.currentTimeMillis();
		joinPoint.proceed();
		
		long endTime=System.currentTimeMillis()-current;
		logger.info(" Time taken by {} is {} ",joinPoint,endTime);
		
	}
	

}

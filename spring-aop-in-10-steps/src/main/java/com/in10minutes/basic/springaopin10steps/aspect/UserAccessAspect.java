package com.in10minutes.basic.springaopin10steps.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
	Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Before("com.in10minutes.basic.springaopin10steps.aspect.CommonJointPointConfig.dataServices()")  //for all classes in the package springaopin10steps
	public void before(JoinPoint joinPoint) {
		logger.info("Performing functions before the execution ");
		logger.info("We are at method  {}",joinPoint);
	}

	
	
}

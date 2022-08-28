package com.in10minutes.basic.springaopin10steps.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJointPointConfig {
	
	@Pointcut("execution(* com.in10minutes.basic.springaopin10steps.data.*.*(..))")
	public void dataServices() {}
	
	
	@Pointcut("execution(* com.in10minutes.basic.springaopin10steps.business.*.*(..))")
	public void businessServices() {}
	
	@Pointcut("dataServices() && businessServices()")
	public void combinedServices() {}
	
	@Pointcut("@annotation(com.in10minutes.basic.springaopin10steps.aspect.TrackTime)")
	public void trackTimeAnnot() {}
	
	
	
	
}

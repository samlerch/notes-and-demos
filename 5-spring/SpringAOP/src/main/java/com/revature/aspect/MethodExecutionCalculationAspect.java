package com.revature.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// We're going to intercept all methods in the business layer and 
	// return the amount of time it takes for us to execute
	
	@Around("execution(* com.revature.business.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// Capture the start time of the method
		long start = System.currentTimeMillis();
		
		log.info("Going before hopefully");
		
		// Give the method permission to continue executing
		joinPoint.proceed();
		
		// capture the end point in milliseconds 
		long end = System.currentTimeMillis();
		
		long timeTake = end - start;
		
		log.info("The time take for {} to execute is {}", joinPoint, timeTake);
	}

}

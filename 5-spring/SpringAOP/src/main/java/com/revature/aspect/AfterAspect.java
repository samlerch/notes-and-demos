package com.revature.aspect;

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
public class AfterAspect {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// General After method
//	@After("execution(* com.revature.business.*.*(..))") // Occurs AFTER any method in business layer
//	public void after (JoinPoint joinpoint) {
//		
//		log.info("After execution of {}", joinpoint);
//	}
//	
//	// After Returning
//	@AfterReturning(
//			value = "execution(* com.revature.business.*.*(..))",
//			returning = "result") // result is a placeholder for the returned item from this method
//	public void after(JoinPoint joinpoint, Object result) {
//		
//		// Log value of return object
//		log.info("{} returned value {}", joinpoint, result);
//	}
//	
//
//	// After throwing
//	@AfterThrowing(
//			value = "execution(* com.revature.business.*.*(..))",
//			throwing = "exception")
//	public void afterThrowing(JoinPoint joinPoint, Object exception) {
//		
//		log.info("{} threw exception {}", joinPoint, exception);
//	}
//		


}

package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect // an aspect is a modularization of a concern that cuts across multiple classes
		// We define what we want to do when we intercept a method from a specific class
@Configuration // This tells spring to configure this aspect into the Global Application
				// Context
				// => @Configuration informs Spring that this class interacts with your beans
public class BeforeAspect {

	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());

	// Use advice to declae WHEN we want to do something
	// We add a pointcut to inform spring of the thing we're intercepting
	// Declare the method that outline WHAT we want to do

	// https://docs.spring.io/spring-framework/docs/2.0.x/reference/aop.html
//	@Before("execution(* com.revature.data.*.*(..))") // execution(* PACAKAGE.*.*(..))
//														// SPring Expression Language (SPeL)
//	public void before(JoinPoint joinpoint) {
//
//		log.info("Checking for user Access");
//
//		log.info("Intercepted Method call of {}", joinpoint);
//	}

	// Before any method in the data layer is called, I want to intercept and log
	// its info and that I'm intercepting it

}

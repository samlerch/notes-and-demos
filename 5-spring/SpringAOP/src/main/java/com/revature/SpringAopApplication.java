package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.business.Business1;
import com.revature.business.Business2;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	// logger
	private Logger log = LoggerFactory.getLogger(this.getClass());

	// We need to inject in our service layers so we can utilize them
	@Autowired
	private Business1 business1;

	@Autowired
	private Business2 business2;

	/**
	 * SpringApplication.run bootstrap (self-start) a spring application as a
	 * stand-alone application from the main method.
	 * 
	 * It creates an appropriate ApplicationContext instance and loads beans that
	 * are marked as @Bean or any Components marked with their respective
	 * annotations @Repository @Controller @Service.
	 * 
	 * IF you have Spring Web Starter as a dependency it also starts an embedded
	 * tomcat server and deploys YOUR APP on the server at port 8080 (default for
	 * tomcat)
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	// The only reason we implemented the CommandLineRunner functional interface
	// is to continue executing code outside of the main method of the Spring Boot
	// App
	@Override
	public void run(String... args) throws Exception {

		// call the calculateSomething() methods from business layers
		log.info(business1.calculateSomething()); // We are logging (printing) the return value from the dao method
		log.info(business2.calculateSomething());

		// Goal: Intercept the calls from the business layer -> data layer and print
		// info about the methods being called
		// We'll do this with AOP

	}

}

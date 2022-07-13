package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	// Let's create some constants

	private static final Logger log = LoggerFactory.getLogger(App.class);
	private static final String CONFIG_LOCATION = "beans.xml";

	public static void main(String[] args) {
		// The Spring IoC container will manage dependency injection for us

		// Step 1. Create the Context (Application Context) by feeding it our config
		// details!
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
		// Bean wiring lives at that location
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Step 2. Instantiate a NumberGenerator Bean using Spring IoC
		NumberGenerator numberGen = context.getBean("myNumGenerator", NumberGenerator.class);
		// This points to the interface that the implementation is implementing

		// Let's pull in our game class impl

		Game game = context.getBean(Game.class);

		// Step 3. call next() (since the bean is fully assembled with its dependency)
		int number = numberGen.next();

		log.info("The number is {}", number);

		game.reset(); // this will print out our new number

		number = game.getNumber();

		log.info("The number is {}", number);
		
		MessageGenerator msg = context.getBean(MessageGenerator.class);
		
		log.info("getMainMessage = {}", msg.getMainMessage());

		context.close(); // This is to prevent memory leakage
	}

}

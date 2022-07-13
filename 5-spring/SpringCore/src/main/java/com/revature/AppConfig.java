package com.revature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * This is programatic configuration of the application context
 * We needs to use annotations to configure our beans & dependencies
 * 
 * This class is a replacement for XML configuration
 * 
 */

@Configuration
@ComponentScan(basePackages = "com.revature")
public class AppConfig {

	@Bean
	public NumberGenerator numberGenerator() {
		return new NumberGeneratorImpl(); // This CAN BE injected into another class because it's annotate with
											// @Component
	}

	@Bean
	public Game game() {
		return new GameImpl(); // Because the numbergenerator property in the GameImpl is autowired
								// Spring IoC container knows that we need to inject a NumberGeneratorImpl into
								// it
	}
	
	@Bean
	public MessageGenerator messageGenerator() {
		return new MessageGeneratorImpl();
	}

}

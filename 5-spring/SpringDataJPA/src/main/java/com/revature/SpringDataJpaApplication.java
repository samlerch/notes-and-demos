package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.models.Food;
import com.revature.service.FoodService;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner{
	
	// Let's add a logger
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	//Autowire in a foodservice dependency to call and insert objects into the DB
	@Autowired
	FoodService foodServ;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Food f1 = new Food("pasta", 200);
		Food f2 = new Food("pizza", 700);
		Food f3 = new Food("ice cream", 400);
		Food f4 = new Food("soup", 150);
		
		foodServ.add(f1);
		foodServ.add(f2);
		foodServ.add(f3);
		foodServ.add(f4);
		
//		log.info(foodServ.findAllFoods().toString());
//		
//		log.info(foodServ.findFoodByDishName("pizza").toString());
//		
//		log.info(foodServ.findByDishNameIgnoreCase("Pizza").toString());
		
		log.info(foodServ.foodNameContains("izz").toString());
		
		log.info(foodServ.foodNameContains("p").toString());
	}

}

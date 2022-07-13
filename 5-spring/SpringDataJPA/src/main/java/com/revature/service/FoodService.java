package com.revature.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.FoodRepository;
import com.revature.models.Food;

// We need to mark the class as a service
@Service
public class FoodService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	// This class is responsible for calling the data layer and its crud methods
	
	@Autowired
	private FoodRepository foodRepo;
	
	// Add
	public int add(Food food) {
		
		// call the repository method to insert a food object into its respective table
		Food savedFood = foodRepo.save(food);
		
		int pk = savedFood.getId();
		
		return pk;
	}

	
	public Food findFoodByDishName(String dishName) {
		
		Optional<Food> possibleFood = foodRepo.findByDishName(dishName);
		
		return (possibleFood.isPresent() ? possibleFood.get() : new Food());
	}
	
	public Food findByDishNameIgnoreCase(String dishName) {
		return foodRepo.findByDishNameIgnoreCase(dishName);
	}
	
	// Find All will come from the JPA Repository
	public List<Food> findAllFoods(){
		
		return foodRepo.findAll();
	}
	
	public List<Food> foodNameContains(String substring) {
		
		Optional<List<Food>> possibleFood = foodRepo.findByDishNameContains(substring);
		
		return (possibleFood.isPresent() ? possibleFood.get() : null);
	}
}

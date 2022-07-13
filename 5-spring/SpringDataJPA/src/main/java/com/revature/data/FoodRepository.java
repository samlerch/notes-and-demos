package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Food;

@Repository // This is marking this interface as a DAO component
public interface FoodRepository extends JpaRepository<Food, Integer>{ // Object, Primary Key Data Type
	
	// Spring Data automatically generates the DAO Impl Class of this interface
	// All our basic crud methods (.save(), .delete(), .update()) Should already exist
	
	public Optional<Food> findByDishName(String dishName); // SELECT * FROM food WHERE dishName = ?
	
	public Food findByCalories(int calories);
	
	public Food findByDishNameIgnoreCase(String dishName);
	
	//Custom Queries
	@Query(value = "FROM Food WHERE dishName like %:substring%")
	public Optional<List<Food>> findByDishNameContains(@Param("substring") String substring);

}

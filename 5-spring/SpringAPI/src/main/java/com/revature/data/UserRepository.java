package com.revature.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	// Spring Data JPA will provide some implementation for us
	public Optional<User> findByUsername(String username);
	
	public List<User> findByOrderByLastName();
	
	@Query("FROM User WHERE email LIKE %:pattern%")
	public List<User> findByEmailContains(String pattern); // Allows us to search for user by email name

}

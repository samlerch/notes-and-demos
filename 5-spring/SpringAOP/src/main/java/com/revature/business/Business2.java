package com.revature.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao2;

@Service
public class Business2 {
	

	// The business/service layer calls upon the data or DAO layer
	
	// We need to inject our DAO
	@Autowired
	private Dao2 dao2;
	
	// Spring automatically understands that a DAO belongs to this class so we can call its methods
	
	public String calculateSomething() {
		
		// This is where we'd put some business logic
		return dao2.retrieveSomething(); // Call to the dao layer
	}

}

package com.revature.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.Dao1;

@Service
public class Business1 {
	
	// The business/service layer calls upon the data or DAO layer
	
	// We need to inject our DAO
	@Autowired
	private Dao1 dao1;
	
	// Spring automatically understands that a DAO belongs to this class so we can call its methods
	
	public String calculateSomething() {
		
		// This is where we'd put some business logic
		return dao1.retrieveSomething(); // Call to the dao layer
	}

}

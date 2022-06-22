package com.revature.dao;

import java.util.List;

import com.revature.models.Account;

public interface IAccountDao {
	
	// Let's define our crud methods
	
	//Create
	int insert(Account a);
	
	// A few methods for read
	
	List<Account> findAll();
	
	Account findById(int id); // Returns account based off Id
	
	List<Account> findByOwner(int accOwnerId); // Since a user can have many accounts we want to be able to return all
	
	// Update
	boolean update(Account a);
	
	// Delete
	
	boolean delete(Account a);

}

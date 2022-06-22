package com.revature;

import java.util.Scanner;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.service.AccountService;
import com.revature.service.UserService;

public class App {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		//Let's just fetch our accounts to test
		
		AccountService as = new AccountService();
		as.viewAllAccounts();
		
		run();
//		ConnectionUtil.getConnection();
//		
//		ConnectionUtil.getConnection();
		
		
	}
	
	public static void run() {
		
		System.out.println("Welcome to our Bank!");
		
		System.out.println("Press 1 if you'd like to register");
		
		int input = scan.nextInt();
		
		if (input == 1) {
			
			System.out.println("Please enter a username");
			String username = scan.next();
			
			System.out.println("Please enter a secure password");
			String password = scan.next();
			
			User u = new User(username, password, Role.Customer, null);
			
			UserService us = new UserService();
			
			us.register(u);
		}
		
	}

}

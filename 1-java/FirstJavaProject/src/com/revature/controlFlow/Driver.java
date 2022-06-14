package com.revature.controlFlow;

public class Driver {
	
	public static void main(String[] args) {
		int temp = 33;
		String day = "Tuesday";
		
		if (temp < 32) {
		// This is where the logic
			System.out.println("It's under freezing");
		} else if (temp == 32) {
			System.out.println("It's 32 degrees exactly");
		} else {
			System.out.println("It's above freezing temps");
		}
		
		// Sample For Loop
	
		// Tuesday
		// 0123456
		for (int i = 0; i < day.length(); i++) {
			System.out.println(day.charAt(i));
		}
		
		System.out.println("============================================");
		
		// Let's go backwards
		
		for (int i =day.length()-1; i>=0; i--) {
			System.out.println(day.charAt(i));
		}
		
		
		// Let's be dangerous
//		while (true) {
//			System.out.println("0");
//		}
		
		int counter = 10;
		
		while (counter > 0) {
			System.out.println("Counter value is " + counter);
			counter--;
		}
		
		// Do While Loop
		
		do {
			System.out.println("Do runs before condition checked");
		} while (false);
		
		
		// Switch Statements
		
		switch(day) {
		case "Tuesday" : System.out.println("Today"); break;
		case "Wednesday" : System.out.println("Tomorrow"); break;
		case "Monday" : System.out.println("Yesterday"); break;
		default: System.out.println("This runs if day not listed");
		}
		
		// Ternary  Operator
		// Like a single line if else statement
		
		int temp2 = 32;
		
		System.out.println((temp2 <= 32) ? "It's under freezing" : "It's not under freezing");
	}

}

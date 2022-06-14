package com.revature.scanner;

import java.util.Scanner;

public class ScannerDriver {
	
	public static void main(String[] args) {
		// Scanner is used for taking in user input
		// First thing, we need to instantiate a scanner object
		
		Scanner scan = new Scanner(System.in); // This creates a new scanner object
		
		// Let's prompt our user to give us their name
		System.out.println("Please enter your name");
		
		// Capture user input using scanner and store it in a variable
		String name = scan.nextLine();
		
		// Asks for user's age
		System.out.println("What's your age?");
		
		int age = scan.nextInt();
		
		System.out.println("In the future you, " + name + ", will be " + getFutureAge(age) + " years old");
		
		scan.close();
	}
	
	public static int getFutureAge(int currentAge) {
		return currentAge + 100;
	}

}

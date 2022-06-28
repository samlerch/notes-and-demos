package com.revature.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// So the goal for this demo is to create a short little "game" of sorts
// We'll have two hackers in the form of two threads
// These hackers will attempt to get into a vault before a third policeman thread catches them
// In about 15 seconds or so
public class Heist {
	
	// I'll have a descending and ascending hacker threads
	// Ascending starts at 0 and goes to the max
	// Descending will start at the max and go to 0
	
	// Let's create a max password
	public static final int MAX_PASSWORD = 9999;
	
	public static void main(String[] args) {
		
		// Instantiate a random password from 0-9999
		Random random = new Random();
		int password = random.nextInt(MAX_PASSWORD);
		
		System.out.println("The secret password is " + password);
		Vault vault = new Vault(password);
		
		List<Thread> threads = new ArrayList<>(); // Can add any object that extends thread
		
		threads.add(new DescendingHackerThread(vault));
		
		// More threads to add in a minute
		threads.add(new AscendingHackerThread(vault));
		threads.add(new PolicemanThread());
		
		// Call a for each method to start each thread
		threads.forEach(t -> t.start());
	}
	
	// Vault -> this represents the resource that all the threads are accessing
	private static class Vault{ // nested inner class -> static, so it can only be instantiated in the main() 
								// method or any method of the Heist.java class
		
		private int password;
		
		public Vault(int password) {
			this.password = password;
		}
		
		// The hacker threads will constantly call a method on the vault
		public boolean isCorrectPassword(int guess) {
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return this.password == guess;
		}
		
	}
	
	private static abstract class HackerThread extends Thread{
		
		protected Vault vault;
		
		// When we instatiate a (desc or asc) hackerthread
		// - pass a vault to their constructor
		// set the name
		// set the priority to max
		
		public HackerThread(Vault vault) {
			this.vault = vault;
			
			// We're going to use some of the methods from thread to set name and priority
			this.setName(this.getClass().getSimpleName()); // Using simple name since normal get class would be like
															// com.revature.multithreading....
			
			this.setPriority(MAX_PRIORITY);
		}
		
		// When the child class runs we want to print to the console that that thread has started
		
		@Override
		public void start() {
			System.out.println("Starting thread: " + this.getName());
			super.start();
		}
		
	}
	
	// Static class descending Hacker Thread extends HackerThread
	private static class DescendingHackerThread extends HackerThread{

		public DescendingHackerThread(Vault vault) {
			super(vault);
		}
		
		// We need to implement the run method
		@Override
		public void run() {
			// What does the run method need to do?
			// It needs to start at the top of all possible passwords and decrement from there
			for (int guess = MAX_PASSWORD -1; guess >=0 ; guess--) {
				
				if (vault.isCorrectPassword(guess)) {
					System.out.println(this.getName() + " guessed the right password! The password was " + guess);
					System.exit(0);
				}
			}
		}
		
	}

	
	// Static class ascending Hacker Thread extends HackerThread
		private static class AscendingHackerThread extends HackerThread{

			public AscendingHackerThread(Vault vault) {
				super(vault);
			}
			
			// We need to implement the run method
			@Override
			public void run() {
				// What does the run method need to do?
				// It needs to start at the bottom of all possible passwords and increment from there
				for (int guess = 0; guess < MAX_PASSWORD ; guess++) {
					
					if (vault.isCorrectPassword(guess)) {
						System.out.println(this.getName() + " guessed the right password! The password was " + guess);
						System.exit(0);
					}
				}
			}
			
		}
		
		// Let's add a challenge for the hackers and add the policeman
		
		private static class PolicemanThread extends Thread{
			
			
			@Override
			public void run() {
				
				// Let's start a loop from 15-0
				for (int i = 15; i> 0; i--) {
					
					// Let's make the thread sleep for 1 second every loop
					
					try {
						Thread.sleep(1000); // This corresponds to 1 second
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					// Print out how many seconds are left after each iteration
					System.out.println(i + " seconds left");
					
				}
				
				// Print out a message saying game over for the hackers
				System.out.println("Game over for you hackers!");
				// Exit program
				System.exit(0);
			}
		}
}

package com.revature.multithreading.deadlock;

/*
 * Causing deadlock..... Two account objects will be created and two threads will be created
 * to transfer funds between each account
 * 
 * In order to prevent and basic errors, each thread will acquire a lock for both objects.
 * The locking process will occur in a separate method called the transfer helper. The first thread will be given a
 * head start to prevent immediate deadlock
 */

public class Launcher {
	
	// Let's create a couple variable which will affect our program
	public static final int INITIAL_BALANCE = 1000;
	public static final int TRANSFER_RATE = 1;
	public static final int SLEEP_TIME = 1;
	
	public static void transferHelper(Account a, Account b) {
		for (int i = 0; i < INITIAL_BALANCE; i++) {
			
			// Let's create a synchronized block to lock the objects in
			
			synchronized (a) {
				synchronized (b) {
					
					a.transfer(b, TRANSFER_RATE);
				}
			}
			
			// Delay a bit after each iteration
			
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		// Create two accounts each with a balance
		Account accountA = new Account(INITIAL_BALANCE);
		Account accountB = new Account(INITIAL_BALANCE);
		
		// Let's create a couple threads to do some transferring
		Thread a = new Thread(new Runnable() {

			@Override
			public void run() {
//				transferHelper(accountA, accountB);
				safeSyncTransferHelper(accountA, accountB);
				
			}
			
		});
		
		Thread b = new Thread(new Runnable() {

			@Override
			public void run() {
//				transferHelper(accountB, accountA);
				safeSyncTransferHelper(accountB, accountA);
				
			}
			
		});
		
		// Let's create one more thread to monitor the states of the other ones
		Thread monitor = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(a.isAlive() && b.isAlive()) {
					System.out.println("Thread A State: " + a.getState() + " Thread B State: " + b.getState());
					System.out.println("Account A: " + accountA);
					System.out.println("Account B: " + accountB);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Complete");
				System.out.println("Account A: " + accountA);
				System.out.println("Account B: " + accountB);
				
			}
		});
		
		// Let's set the names for each thread 
		a.setName("a");
		b.setName("b");
		monitor.setName("monitor");
		
		// Let's start a and then give it a little head start
		
		a.start();
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b.start();
		monitor.start();
		
		
	}
	
	public static void safeSyncTransferHelper(Account sender, Account recipient) {
		// To make this safe we need to ensure that the accounts are synchronized in the same order
		// For each thread
		
		/*
		 * Example: Account a's hashcode is 3
		 * Account b's hashcode is 2
		 * So if I can safeSyncTransferHelper(a, b)
		 * This is when account a is the sender and account b is the recipient
		 * We'll do a check inside the method to check these hash codes
		 * 3>2 so a becomes the A inside the method
		 * 
		 * If we flip the order then we have
		 * safeSyncTransferHelper(b,a)
		 * Then we check hash code and see
		 * that 2>3 is false so the A becomes the second paramter or the recipient in this case
		 */
		
		Account A = sender.hashCode() > recipient.hashCode() ? sender : recipient;
		Account B = A.equals(sender) ? recipient : sender;
		
		
		for (int i = 0; i < INITIAL_BALANCE; i++) {
			
			// Let's create a synchronized block to lock the objects in
			
			synchronized (A) {
				synchronized (B) {
					
					sender.transfer(recipient, TRANSFER_RATE);
				}
			}
			
			// Delay a bit after each iteration
			
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

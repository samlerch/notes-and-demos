package com.revature.multithreading;

public class ThreadCreationDriver {
	
	public static void main(String[] args) {
		// Let's explore the different ways to make threads
		
		// 1. Implement runnable interface and pass to a new thread's constructor
		// External Class
		Thread t1 = new Thread(new myRunnableClass());
		
		// Anonymous class 
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Running from an anonymous class");
				
			}
			
		});
		
		// Create a lambda expression
		
		Thread t3 = new Thread(()-> System.out.println("Printing from the lambda thread"));
		
		
		// 2. Extend the thread class and create an object of that class
		Thread t4 = new MyThread();
		
		
		
		t4.setName("My extended thread class");
		
		t4.setPriority(Thread.MAX_PRIORITY);
		
		t4.start();
		t1.start();
		t2.start();
		t3.start();
		
		
		
	}
	
	
	private static class MyThread extends Thread{
		
		public void run() {
			System.out.println("Hello from " + this.getName());
		}
	}

}

class myRunnableClass implements Runnable{

	@Override
	public void run() {
		System.out.println("From the runnable class");
		
	}
	
	
}

package com.revature.multithreading.producerconsumer;

public class Driver {
	
	public static void main(String[] args) {
		
		Holder data = new Holder();
		int numValuesToGenerate = 10;
		
		Thread producerThread = new Thread(new Producer(data, numValuesToGenerate)); // pass through the producer
		
		Thread consumerThread = new Thread(new Consumer(data, numValuesToGenerate)); // pass throught the consumer
		
		System.out.println("Starting threads");
		
		producerThread.start();
		consumerThread.start();
	}

}

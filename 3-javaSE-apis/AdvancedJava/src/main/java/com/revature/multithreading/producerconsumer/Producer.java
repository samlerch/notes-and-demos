package com.revature.multithreading.producerconsumer;

public class Producer implements Runnable {
	
	public Holder data;
	int max;
	
	public Producer(Holder data, int max) {
		this.data = data;
		this.max = max;
	}

	@Override
	public void run() {
		// open up a for loop and iterate to the max
		
		for(int i = 0; i<=max; i++) {
			
			this.data.setVal(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("The producer produced: " + i);
		}
		
	}

}

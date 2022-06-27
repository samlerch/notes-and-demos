package com.revature.multithreading.producerconsumer;

public class Consumer implements Runnable{
	
	public Holder data;
	int max;
	
	

	public Consumer(Holder data, int max) {
		super();
		this.data = data;
		this.max = max;
	}



	@Override
	public void run() {
		// Open up a loop and iterate to the max
		for (int i =0; i<=max; i++) {
			int currentVal = this.data.getVal();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("The consumer got: " + currentVal);
		}
		
	}

}

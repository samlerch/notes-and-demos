package com.revature;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator{
	
	// Fields
	
	private final Random random = new Random(); // Object that creates random numbers
	
	private int maxNumber = 100;

	@Override
	public int next() {
		return random.nextInt(maxNumber); // Prints a random number up to the upper bound
	}

	@Override
	public int getMaxNumber() {
		return maxNumber;
	}

}

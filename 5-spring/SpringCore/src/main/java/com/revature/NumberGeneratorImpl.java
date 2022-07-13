package com.revature;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("myNumGenerator") // We're identifying this class as a possible dependency (Spring bean) for
								// another class (GameImpl in this case)
public class NumberGeneratorImpl implements NumberGenerator {

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

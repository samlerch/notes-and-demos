package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GameImpl implements Game {

	// Call some constants
	private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

	// Fields
	private int guessCount;
	private int number;
	private int guess;
	private int smallest;
	private int biggest;
	private int remainingGuesses;
	private boolean validNumberRange = true;

	// Let's add the field for the number generator interface (we're using the
	// interface because we don't
	// necessarily care about the actual implementation, just that it does have an
	// implementation)

	// Now let's use annotation based configuration
	@Autowired // This Spring IoC knows that this is a dependency of this class this is the
				// IoC's responsibility to handle
	private NumberGenerator numberGenerator; // The question becomes how do we fulfill this dependency

	// CONSTRUCTOR INJECTION
//	public GameImpl(NumberGenerator numberGenerator) {
//		this.numberGenerator = numberGenerator;
//	}

	// SETTER INJECTION
//	public void setNumberGenerator(NumberGenerator numberGenerator) {
//		this.numberGenerator = numberGenerator;
//	}

	@Override
	public void reset() {
		smallest = 0;
		guess = 0;
		remainingGuesses = guessCount;

		// We need to pull the biggest number and actually create the number
		biggest = numberGenerator.getMaxNumber();
		number = numberGenerator.next();

		// We'll print out the value using logs

		log.info("The number is {}", number); // The {} are a placeholder for the value in the second parameter

	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public int getGuess() {
		return guess;
	}

	@Override
	public void setGuess(int guess) {
		this.guess = guess;

	}

	@Override
	public int getSmallest() {
		return smallest;
	}

	@Override
	public int getBiggest() {
		return biggest;
	}

	@Override
	public int getRemainingGuesses() {
		return remainingGuesses;
	}

	@Override
	public void check() {

		checkValidNumberRange();

		if (validNumberRange) {
			if (guess > number) {
				biggest = guess - 1;
			}
			if (guess < number) {
				smallest = guess + 1;
			}
		}

		remainingGuesses--;
	}

	@Override
	public boolean isValidNumberRange() {
		return validNumberRange;
	}

	@Override
	public boolean isGameWon() {
		return guess == number;
	}

	@Override
	public boolean isGameLost() {
		return !isGameWon() && remainingGuesses <= 0;
	}

	// Let's create one more helper method

	private void checkValidNumberRange() {
		validNumberRange = (guess >= smallest) && (guess <= biggest);
	}

}

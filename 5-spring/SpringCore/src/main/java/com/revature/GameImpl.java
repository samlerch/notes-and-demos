package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGuess() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setGuess() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSmallest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBiggest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRemainingGuesses() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public void check() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValidNumberRange() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGameWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGameLost() {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.revature;

public interface Game {
	
	int getNumber();
	
	int getGuess();
	
	void setGuess(int guess);
	
	int getSmallest();
	
	int getBiggest();
	
	int getRemainingGuesses();
	
	void reset(); // Resets the number by call the next() on the random obj
	
	void check();
	
	boolean isValidNumberRange();
	
	boolean isGameWon();
	
	boolean isGameLost();

}

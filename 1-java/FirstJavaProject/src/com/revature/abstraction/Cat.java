package com.revature.abstraction;

// Extends the Animal Abstract class
public class Cat extends Animal{
	
	private boolean hasFur;

	@Override
	public void makeSound() {
		System.out.println("Meow");
		
	}

	public Cat(boolean hasFur) {
		super();
		this.hasFur = hasFur;
	}

	public boolean isHasFur() {
		return hasFur;
	}

	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	
	// Can also override any method that we've inherited along the way
	
	@Override
	public String toString() {
		return "Cat [hasFur = " + hasFur + "]";
	}

}

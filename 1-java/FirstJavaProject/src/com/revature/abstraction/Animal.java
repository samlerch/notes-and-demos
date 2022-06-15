package com.revature.abstraction;

public abstract class Animal {
	
	private int legs;
	private String color;
	
	public Animal() {
		System.out.println("Animal Constructor Called");
	}
	
	// Abstract methods have no body and are intended to be inherited
	
	public abstract void makeSound();
	
	// Abstract Classes can also have concrete methods
	
	public void exist() {
		System.out.println("I EXIST");
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}

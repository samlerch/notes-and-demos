package com.revature.abstraction;

public class AnimalDriver {
	
	public static void main(String[] args) {
		
		Cat a1 = new Cat(true);
		
		a1.makeSound();
		
		System.out.println(a1.toString());
		
		Frog a2 = new Frog();
		
		a2.makeSound();
		
		// Liskov Principle
		Animal a3 = new Cat(true);
		
		// Animal is the reference type
		
		a3.exist();
		
		a3.makeSound();
		
		// Let's change to a frog
		
		a3 = new Frog();
		
		a3.makeSound();
	}

}

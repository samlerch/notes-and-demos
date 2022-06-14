package com.revature;

public class HelloWorld {
	
	public static void main(String[] args) {
		System.out.println("Testing Printing to the console");
		
		
		// Let's create some primitive values
		boolean isCool = true;
		byte reallySmallNumber = 127;
		int standardNum = 10000000;
		short shortNumber = 32767;
		char letter = 'm';
		double decimal = 20.45;
		
		//Float and long are slightly different
		long bigNumber = 12345678L;
		float lessPreciseDouble = 93.2f;
		
		// Widening and Narrowing
		
		// Widening is implicit can happen automatically
		byte a = 40;
		short b = a;
		int c = b;
		
		// Narrowing
		// Narrowing is explicit because data can be lost
		
		double dub = 900.9;
		int myInt = (int) dub;
		
		System.out.println("The double has been explicitly cast and now is equal to " + myInt);
		
		// Let's look at wrapper classes in action!
		
		int min;
		
		min = Integer.MIN_VALUE;
		
		System.out.println("The minimum value of an integer is " + min);
		
		// Object Instantiation
		
		// MyClass myObj = new MyClass();
		
		Integer obj1 = new Integer(20); // Whenever we create a new object using new, it creates a new object in memory
		Integer obj2 = new Integer("20");
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		// Checking equality
		// .equals() checks value and == check memory address
		
		System.out.println(obj1.equals(obj2)); //true 
		
		System.out.println(obj1 == obj2); // false
		
		// Reassign obj2
		
		obj2 = obj1;
		
		System.out.println(obj1 == obj2);
		
		// Slightly different for prims
		int test = 5;
		System.out.println(test == 5);
		
		int textToNumber = Integer.parseInt("2500");
		
		System.out.println(textToNumber + 1);
		
		int n = 5;
		someMethod(n);
		
	}
	
	public static void someMethod(Integer i) {
		System.out.println(i + 3);
	}
	
	

}

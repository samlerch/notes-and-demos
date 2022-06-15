package com.revature.arrays;

import java.util.Arrays;

public class ArrayDriver {
	
	public static void main(String[] args) {
		// There are two steps to creating an array
		// Declaration and initialization
		int myInt;
		byte[] bytes; // Declaration
		bytes = new byte[16]; // Initialize
		
		// Combine together to get one line
		int capacity = 5;
		
		String[] wordsStrings = new String[capacity];
		
		Object[] myObjects;
		
		// Another way to initialize an array
		
		String[] cars = {"bugatti", "jeep", "audi", "nissan"};
		
		// [_0_1_2_3________]
		System.out.println(cars[1]);
		
		
		int[] numbers = new int[10];
		
		
		System.out.println(numbers[3]);
		
		// We'll come back to this later
//		System.out.println(cars);
		
		// Assign values to a specific index
		numbers[2] = 30;
		numbers[0] = 10;
		
		System.out.println(numbers[0]);
		
		System.out.println("========================================");
		
		
		// Let's assign each index to be 100* the index
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (i * 100);
		}
		
		// Let's print this using a enhanced for loop
		for (int n: numbers) {
			System.out.println(n);
		}
		
		System.out.println("=========================");
		
		someVarArgMethod(1,2,3);
		someVarArgMethod(1,2,3,4,5);
		someVarArgMethod(1);
		
		System.out.println("======================");
		
		// Cool stuff associated with arrays
		
		String[] fruit = {"fig", "orange", "kiwi", "apple"};
		
		// We want to print some value we can
		System.out.println(fruit[1]);
		// How do we print the entire array?
		// We need to import the Arrays Class
		System.out.println(Arrays.toString(fruit));
		Arrays.sort(fruit); // Sorts ascending
		System.out.println(Arrays.toString(fruit));
		
	}
	
	public static void someVarArgMethod(int... myInts) {
		int sum = 0;
		for (int n: myInts) {
			sum += n;
		}
		System.out.println(sum);
	}
	                                                 

}

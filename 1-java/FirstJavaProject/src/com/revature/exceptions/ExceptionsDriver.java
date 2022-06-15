package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionsDriver {
	
	public static void main(String[] args) {
		
		int x = 10;
		int y = 0;
		
		
//		System.out.println("Before the exception");
		
		try {
			System.out.println(divideDucked(x, y));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		
//		System.out.println("After the exception");
		try {
			createFileCheckedException("something", "Some text");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		checkAge(20);
		
	}
	
	public static int divideDucked(int x, int y) throws ArithmeticException{
		return  x/y;
	}

	public static int divide(int x, int y) {
		
		// Let's refactor to handle exception
//		return x/y;
		
		try {
			int z = x/y;
			return x/y;
			
		} catch (ArithmeticException e) {
			e.printStackTrace();
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
//		} finally {
//			System.out.println("I made it to the finally block");
//		}
	}
	
	static void createFileCheckedException(String path, String text) throws IOException {
		
		
		FileWriter writer;
		
		writer = new FileWriter(path, true);
		writer.write(text);
		writer.close();
//		try {
//			writer = new FileWriter(path, true);
//			writer.write(text);
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}
	
	static void checkAge(int age) {
		
		if (age< 21) {
			throw new RuntimeException("Sorry you're " + age + " which is under 21");
		} else {
			System.out.println("Welcome!");
		}
	}
}

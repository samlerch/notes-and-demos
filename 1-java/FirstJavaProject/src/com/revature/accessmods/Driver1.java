package com.revature.accessmods;

public class Driver1 {

	public int publicField = 1;
	protected int protectedField = 2;
	int defaultField = 3;
	private int privateField = 4;
	
	public static void main(String[] args) {
		
		Driver1 d1 = new Driver1();
		
		System.out.println(d1.publicField);
		System.out.println(d1.protectedField);
		System.out.println(d1.defaultField);
		System.out.println(d1.privateField);
	}
}

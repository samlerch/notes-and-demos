package com.revature.polymorphism;

public class Oveerloading {
	
	public static void main(String[] args) {
		overloadMe();
		overloadMe("Some String");
		overloadMe("SomeString Again", 3);
		overloadMe(0, "Some String again");
	}
	
	public static void overloadMe() {
		System.out.println("no arg method");
	}
	
	public static void overloadMe(String s) {
		System.out.println("Method with string arg: " + s);
	}
	
	public static void overloadMe(String s, int i) {
		System.out.println(s + " " + i);
	}
	
	public static void overloadMe(int i, String s) {
		System.out.println(i + " " + s);
	}

}

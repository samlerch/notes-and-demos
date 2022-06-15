package com.revature.polymorphism;

public class Parent {
	
	protected Object getObj() {
		System.out.println("Can we change the return type?");
		return new Object();
	}
	
	protected void changeAccess() {
		System.out.println("Can We change access?");
	}

}

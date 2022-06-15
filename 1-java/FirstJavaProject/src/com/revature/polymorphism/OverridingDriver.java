package com.revature.polymorphism;

public class OverridingDriver {
	
	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.getObj();
		p1.changeAccess();
		
		Overriding o1 = new Overriding();
		System.out.println(o1.getObj());
		o1.changeAccess();
	}

}

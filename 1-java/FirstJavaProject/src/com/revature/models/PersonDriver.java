package com.revature.models;


public class PersonDriver {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		
		Person p2 = new Person("Jerry");
		
		Person p3 = new Person("Sally", 40, 5.6, 150);
		
		System.out.println(p2.getName());
		System.out.println(p3.getName());
		
		p2.setName("Joe");
		
		System.out.println(p2.getName());
	}
	
}

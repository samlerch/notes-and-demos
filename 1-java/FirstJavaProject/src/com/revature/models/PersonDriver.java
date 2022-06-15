package com.revature.models;


public class PersonDriver {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		
		Person p2 = new Person("Jerry");
		
		Person p3 = new Person("Sally", 40, 5.6, 150);
		
//		System.out.println(p2.getName());
//		System.out.println(p3.getName());
//		
		p2.setName("Joe");
		
//		System.out.println(p2.getName());
		
		// Liskov Substitution Principle
		Person e1 = new Employee("Finance");
		
		Employee e2 = new Employee("Finance");
		
		
		// Person is the reference type
		
		e1.walk(15);
		
		e1.setName("Bob");
		
		System.out.println(e1.getName());
		
		e2.complain("Finance");
		
		e1 = new Artist();
	}
	
}

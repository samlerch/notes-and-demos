package com.revature.models;



// To inherit from another class we use extends
public class Employee extends Person{

	public String dept;
	
	public  void complain(String dept) {
		System.out.println("Oh man I hate working in the " + dept + " department!");
	}

	public Employee(String dept) {
		super();
		this.dept = dept;
	}
	
	
}

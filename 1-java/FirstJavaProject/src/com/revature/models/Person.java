package com.revature.models;

public class Person {
	
	// Properties or states
	 String name;
	 int age;
	 double height;
	 double weight;
	
	public void walk(int feet) {
		System.out.println("I walked " + feet + " feet!");
	}
	
	public  void introduce(String name) {
		System.out.println("Hey my name is " + name);
	}
	
	// No arg constructor
	public Person() {
		
	}
	
	// Single arg constructor
	public Person(String name) {
//		super();
		this.name = name;
	}

	// All args constructor
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	
	

}

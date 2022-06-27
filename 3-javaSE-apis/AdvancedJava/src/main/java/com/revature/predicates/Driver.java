package com.revature.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.lambdas.Employee;

// Consumer, Supplier, and Predicate are all function interfaces
// Predicate has a test method that we're going to implement
public class Driver {

	public static void main(String[] args) {
		// Let's instantiate a few employees

				Employee zayn = new Employee("Zayn Smith", 42);
				Employee abby = new Employee("Abby McCormik", 36);
				Employee edward = new Employee("Edward Zyrtec", 56);
				Employee xavier = new Employee("Xavier Hall", 19);

				// Create some arraylist of employees and add them to it
				List<Employee> employees = new ArrayList<>();

				employees.add(zayn);
				employees.add(abby);
				employees.add(edward);
				employees.add(xavier);
				employees.add(new Employee("Someone Smith", 22));
				
				// Let's look at using consumer real quick
				
				employees.forEach(e -> System.out.println(e));
				
				System.out.println("=======================");
				
				// Method referencing
				
				employees.forEach(System.out::println);
				
				System.out.println("=======================");
				
				// Anonymous class
				// Implements the 'accept' method
				employees.forEach(new Consumer<Employee>() {

					@Override
					public void accept(Employee t) {
						System.out.println(t);
						
					}
					
				});
				
				System.out.println("=======================");
				
				// Passing in a class that provides a direct implementation
				
				employees.forEach(new doSomething());
				
				System.out.println("=======================");
				
				// Let's look at the predicate interface
				// You need to provide an implementation to the test() method 
				// Let's try the anonymous class way first
				
				printEmployeesByAge(employees, new Predicate<Employee>() {

					@Override
					public boolean test(Employee t) {
						// TODO Auto-generated method stub
						return t.getAge() > 30;
					}
				});
				
				System.out.println("=======================");
				
				// Let's use lambdas to do this too
				
				printEmployeesByAge(employees, emp -> emp.getAge() > 30);
				
				// Primitive Functional Interfaces
				IntPredicate greaterThan15 = i -> i > 15;
				int someVar = 10;
				System.out.println("Is 10 greater than 15? " + greaterThan15.test(someVar));
				
				// Predicate Chaining
				IntPredicate lessThan100 = i -> i< 100;
				System.out.println("Is 10 greater than 15 AND less than 100? " + greaterThan15.and(lessThan100).test(someVar));
	}
	
	
	//Predicate Interface comes from java.util.function
	private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> ageCondition) {
		
		for (Employee e: employees) {
			
			if (ageCondition.test(e)) {
				System.out.println(e.getName() + " passed the predicate test!");
			}
		}
		
	}
}

class doSomething implements Consumer<Employee>{

	@Override
	public void accept(Employee t) {
		System.out.println(t);
		
	}
	
}

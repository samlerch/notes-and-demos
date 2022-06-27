package com.revature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

		// Let's use method referencing to print them our
		employees.forEach(System.out::println);

		System.out.println("==================================");

		// Let's use sort and utilize this comparator
		Collections.sort(employees, new NameSorter());

		employees.forEach(System.out::println);

		System.out.println("==================================");

		// We could do the same thing using an anonymous class

		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {

				return o1.getName().compareTo(o2.getName());
			}

		});

		employees.forEach(System.out::println);

		System.out.println("==================================");
		
		
		// The "best" way to handle this would be a lambda expression
		
		Collections.sort(employees, (emp1, emp2) -> emp1.getName().compareTo(emp2.getName()));
		
		employees.forEach(System.out::println);

		System.out.println("==================================");
		
		
		// Let's sort using the age sorter
		Collections.sort(employees, new AgeSorter());
		
		employees.forEach(System.out::println);
	}

}

class NameSorter implements Comparator<Employee> {

	// This method is compare not compareTo
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

class AgeSorter implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// Let's use a fun nested ternary operator
		return o1.getAge() < o2.getAge() ? -1 : o1.getAge() > o2.getAge() ? 1 : 0;
	}
	
}

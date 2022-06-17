package com.revature.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WildcardDriver {

	
	public static void main(String[] args) {
		
		List<Integer> list1 = new LinkedList<>();
		list1.add(12);
		list1.add(235);
		
		printList(list1);
		
		List<Animal> list2 = new ArrayList<>();
		Animal a1 = new Animal("Cat", 7);
		Animal a2 = new Animal("Shark", 15);
		
		list2.add(a1);
		list2.add(a2);
		
		printList(list2);
		
		List<Double> list3 = Arrays.asList(2.09, 76.2, 11.9);
		
		System.out.println(add(list1));
		System.out.println(add(list3));
//		System.out.println(add(list2));
		
	}
	
	// ? denotes a wildcard type or essentially any type can go in there
	private static void printList(List<?> list) {// By using list I can say ArrayList, LinkedList or a Vector
		System.out.println(list);
	}
	
	
	// Upper Bounded Wildcard 
	private static double add(List<? extends Number> list) {
		double sum = 0.0;
		
		for (Number n: list) {
			
			sum+=n.doubleValue();
			
		}
		
		return sum;
	}
}

package com.revature.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class CollectionsDriver {

	public static void main(String[] args) {
		
		// A list is an ordered collection that may contain duplicates
		// The list interface has operations for positional access, searching, and iteration
		// There are two general purpose list implementations
		
		// ArrayList
		
		// Fast Retrieval using the .get() method
		// Slower insertion and deletion
		
		List<Integer> numbers = new ArrayList<>(); // Declaring a new ArrayList
		
		List<Integer> numbIntegers = new ArrayList<>(10);
		
		// Method for adding to the list
		
		// Technically slow O(n)
		numbers.add(1);
		numbers.add(8);
		numbers.add(12);
		
		System.out.println(numbers.size());
		System.out.println(numbIntegers.size());
		
		// View all elements in the ArrayList
		System.out.println(numbers);
		
		// Fast retrieval using get()
		System.out.println(numbers.get(1));
		
		// Alter items in the list
		// use set
		
		numbers.set(2, 5);
		
		System.out.println(numbers);
		
		// Deletion 
		numbers.remove(2);
		System.out.println(numbers);
		
		// Searching Abilities
		
		numbers.add(5);
		numbers.add(5);
		numbers.add(6);
		
		System.out.println(numbers);
		
		// Returns first index
		System.out.println(numbers.indexOf(5));
		// return -1 if not found
		System.out.println(numbers.indexOf(21));
		
		// Get the last index of a value
		System.out.println(numbers.lastIndexOf(5));
		
		// Just check for true/false of if an element exists in the ArrayList
		System.out.println(numbers.contains(4));
		
		// Sort using the collections class
		Collections.sort(numbers);
		System.out.println(numbers);
		
		// Let's look at creating a custom class to check some of these things
		System.out.println("==========================");
		Animal a1 = new Animal("Tiger", 12);
		Animal a2 = new Animal("Dog", 4);
		Animal a3 = new Animal("Tiger", 12);
		
		System.out.println(a1.equals(a3));
		
		List<Animal> animals = new ArrayList<>();
		
		animals.add(a1);
		animals.add(a2);
		animals.add(a3);
		
		System.out.println(animals);
		
		// We can iterate over these
		
		for (Animal a : animals) {
			System.out.println(a.getSpecies());
		}
		
		// Let's take a look at a linkedlist
		
		List<Integer> linkednums = new LinkedList<>();
		
		// Fast insertion / deletion
		linkednums.add(1);
		linkednums.add(2);
		linkednums.add(45);
		linkednums.add(6);
		
		System.out.println(linkednums);
		
		// Slower on retrieval
		System.out.println(linkednums.get(2));
		
		// Vectors are threadsafe ArrayLists
		
		List<Integer> threadSafeNumbers = new Vector<>();
		
		threadSafeNumbers.add(3);
		threadSafeNumbers.add(74);
		threadSafeNumbers.add(-9000);
		
		System.out.println(threadSafeNumbers);
		
		System.out.println("=========Sets Below=============");
		
		// Let's talk about hashsets
		
		Set<Animal> animalSet = new HashSet<>();
		
		animalSet.add(a1);
		animalSet.add(a2);
		animalSet.add(a3); // This is a duplicate of a1 so it's not added
		
		System.out.println(animalSet);
		
		
		// Let's search for the dog
		for (Iterator<Animal> iterator = animalSet.iterator(); iterator.hasNext(); ) {
			Animal animal = iterator.next();
			
			if (animal.equals(a2)) {
				System.out.println("I found the dog");
			}
		}
		
		// Another way to iterate over a set
		
		for (Animal a : animalSet) {
			if(a.equals(a2)) {
				System.out.println("Found the dog again");
			}
		}
		
		Set<Integer> intSet = new HashSet<>();
		
		for (int i = 10; i > 0; i--) {
			intSet.add(i);
		}
		
		System.out.println(intSet);
		
		// Search across this
		System.out.println(intSet.contains(3));
		
		System.out.println("==================");
		
		List<Integer> whatevr = new ArrayList<>(3);
		
		System.out.println(whatevr);
		
		System.out.println(whatevr.size());
		
		
		System.out.println("+--------------------+");
		a1 = new Animal("Tiger", 12);
		a2 = new Animal("Dog", 4);
		a3 = new Animal("Bear", 5);
		
		
		System.out.println("============QUEUES============");
		
		Queue<Animal> animalQ = new LinkedList<Animal>();
		
		animalQ.add(a1);
		animalQ.add(a2);
		animalQ.add(a3);
		
		System.out.println(animalQ);
		
		// Iterating over the queue
		
		while(animalQ.size() != 0) {
			System.out.println("Queue Size: " + animalQ.size());
			
			// We'll call the .poll method to remove the head of the queue
			System.out.println("Processing ... " + animalQ.poll());
			
			// Lets view the remaining queue
			System.out.println(animalQ);
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		deque.offer(10);
		deque.offer(20);
		deque.offer(30);
		
		System.out.println(deque);
		
		deque.addFirst(564);
		deque.addFirst(291);
		
		System.out.println(deque);
		
		deque.addLast(24);
		deque.addLast(14);
		
		System.out.println(deque);
		
		System.out.println("Peeking at the head... " + deque.peekFirst());
		
		System.out.println("Peeking at the tail..." + deque.peekLast());
		
		System.out.println("Poll from the head ..." + deque.pollFirst());
		
		System.out.println("Poll from the tail..." + deque.pollLast());
		
		System.out.println(deque);
		
		
		
		
		
	}
}

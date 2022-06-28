package com.revature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Driver {
	
	/*
	 * Stream API was introduced in Java 8
	 * It is used to process a collection of objects.
	 * 
	 * A stream is NOT a collection. It is a sequence of object references that 
	 * support various methods that can be pipelined to produce a desired result,
	 * without changing the underlying data source
	 * 
	 * We can use streams to take input from Collections, Arrays, or IO channels
	 */
	
	public static void main(String[] args) {
		
		List<String> bingoNums = Arrays.asList(
				"N40", "N46",
				"B12", "B6",
				"G53", "G42", "g15",
				"I12", "I09"
				);
		
		
		// Print all the bingo nums like we did yesterday
		bingoNums.forEach(n -> {
			// Let's parse to only return those that start with G
			if(n.startsWith("G")) {
				System.out.println(n);
			}
		});
		
		System.out.println("================================");
		
		bingoNums.stream()
			.map(n -> n.toUpperCase()) // What map does is it applies a function to every element in the stream
			.filter(n -> n.startsWith("G")) // Filter will filter the results based off some criteria
			.sorted() // This will sort the data that we're looking at
			.forEach(System.out::println);
		
		
		System.out.println("===============================");
		
		// We can collect these into an actual list by using .collect()
		
		List<String> gNumsOnly = bingoNums.stream()
				.map(n -> n.toUpperCase()) 
				.filter(n -> n.startsWith("G")) 
				.sorted() 
				.collect(Collectors.toList());
		
		gNumsOnly.forEach(System.out::println);
		
		
		// Let's work a little with optionals
		Optional<String> aNum = bingoNums.stream()
								.map(String::toUpperCase) //.map will apply this to every element in stream
								.filter(n -> n.startsWith("A"))
								.findFirst(); // Find the first aNum that exits
		
		// If it doesn't exist then aNum will be null
		
		if (aNum.isPresent()) {
			System.out.println(aNum);
		} else {
			System.out.println("Sorry the optional returned as null because no anums exist");
		}
		
		System.out.println(bingoNums);
	}
	
	

}

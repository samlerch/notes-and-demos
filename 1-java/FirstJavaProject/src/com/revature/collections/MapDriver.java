package com.revature.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDriver {

	
	public static void main(String[] args) {
		
		// Building a programming language dictionary with a key and value
		Map<String, String> languages = new HashMap<>();
		
		
		// Use .put() to insert data into a map
		
		languages.put("Java", "a high leveled compiled OO programming language");
		languages.put("Python", "an interpreted OOP language");
		languages.put("JavaScript", "interpreted, multi paradigm language that runs in a browser or Node.js");
		
		languages.get("Java");
		
		System.out.println(languages.get("Java"));
		
		String newValue = languages.get("JavaScript") + "ABC";
		
		System.out.println(newValue);
		
		// To update to value we use the put method
		languages.put("JavaScript", newValue);
		
		System.out.println(languages.get("JavaScript"));
		
		Map<Integer, String> randomMap = new HashMap<>();
		
		randomMap.put(1, "one");
		randomMap.put(2, "two");
		
		// Prints all Keys
		for(int i: randomMap.keySet()) {
			System.out.println(i);
		}
		
		// Prints all values
		for(String i: randomMap.values()) {
			System.out.println(i);
		}
		
		// Print all entries
		for (Map.Entry<String, String> entry: languages.entrySet()) {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("============");
		}
		
	}
}

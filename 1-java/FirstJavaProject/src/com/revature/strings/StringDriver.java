package com.revature.strings;

public class StringDriver {
	
	public static void main(String[] args) {
		
		String str1 = "hi";
		
		String str2  = "hi";
		
		System.out.println(str1 == str2);
		
		String str3  = new String("hi");
		
		System.out.println(str1 == str3);
		
		String str4 = "hi";
		
		// Reassign string 2
		
		str2 = "hello";
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str4);
		
		// Let's Check out some of the cool string methods
		
		String testString = "This is my testing string, it's very cool";
		
		testString.replaceAll(" ", "_");
		System.out.println(testString);
		System.out.println(testString.replaceAll(" ", "_"));
		System.out.println(testString.toUpperCase());
		System.out.println(testString.toLowerCase());
		
		
		// Let's Look at string builder / buffer
		
		StringBuilder sb = new StringBuilder();
		
		System.out.println(sb);
		
		
		
		sb.append("t");
		sb.append("e");
		sb.append("s");
		sb.append("t");
		
		sb.insert(3, "Try this");
		
		System.out.println(sb);
		
		String str5 = "";
		str5 = str5.concat("t");
		System.out.println(str5);
	}

}

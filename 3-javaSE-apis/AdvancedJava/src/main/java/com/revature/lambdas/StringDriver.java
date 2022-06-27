package com.revature.lambdas;

public class StringDriver {
	
	public static void main(String[] args) {
		
		// Lets look at using our functional interface
		// Let's use an anonymous class
		String sillyString = doStringStuff(new UpperConcat() {
			
			@Override
			public String upperAndConcat(String s1, String s2) {
				// TODO Auto-generated method stub
				return s1.toUpperCase() + s2.toUpperCase();
			}
		}, "String x", "String y");
		
		System.out.println(sillyString);
		
		// We should try this with a lambda
		
		String sillyStringTwo = doStringStuff((s1 ,s2) -> {
			return s1.toUpperCase() + s2.toUpperCase();
		}, "String x", "String y");
		
		System.out.println(sillyStringTwo);
	}

	
	public static String doStringStuff(UpperConcat uc, String s1, String s2) {
		
		return uc.upperAndConcat(s1, s2);
	}
}

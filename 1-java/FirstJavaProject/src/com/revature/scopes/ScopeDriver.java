package com.revature.scopes;



public class ScopeDriver {
	
	public static void main(String[] args) {
		// Word is method scoped so we can't use it outside the method
		String word = "hello!";
		
		ScopeDriver driver = new ScopeDriver();
		int product = driver.multiply(42); 
		
		int x = MyClass.myStaticVariable;
		
		MyClass myObjClass = new MyClass();
		int y = myObjClass.myInstanceVar; // Need to pull from the instance itself
	}

//	word ="hi";
	
	public int multiply(int num) {
		MyClass objClass = new MyClass();
		// Need to instantiate class for instance method
		objClass.myMethod();
		
		return num * 100;
	}
	
}

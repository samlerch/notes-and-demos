package com.revature.otherPackage;

import com.revature.accessmods.Driver1;
import com.revature.scopes.MyClass;

public class Driver4 extends Driver1{
	
	int x = publicField;
	int y = protectedField;
	// int z = defaultField;
	
	// int w = privateField;
	
	int z = MyClass.myStaticVariable;
	
	public static void main(String[] args) {
		MyClass.myMethod();
	}

}

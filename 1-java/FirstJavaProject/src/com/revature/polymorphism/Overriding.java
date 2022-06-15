package com.revature.polymorphism;

import java.security.spec.XECPublicKeySpec;

public class Overriding extends Parent{
	
	@Override
	protected String getObj() {
		
		return "Yes";
	}
	
	@Override
	public void changeAccess() {
		System.out.println("Yes we can!");
	}

}

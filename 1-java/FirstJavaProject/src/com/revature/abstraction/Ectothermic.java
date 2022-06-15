package com.revature.abstraction;

public interface Ectothermic {
	
	// Fields in interfaces are all public static and final by default
	public static final int minBodyTemp = -40;
	int maxBodyTemp = 90; // Still public static and final
	
	// Methods are abstract and public
	
	public abstract void heatUp();
	
	void coolDown(); // Still public and abstract
	
	// default and static were allowed since Java 8 but now we have specify static/default
	default void saySomething() {
		System.out.println("I can provide implementation");
	}
}

package com.revature;

import com.revature.inspection.ClassInspector;
import com.revature.models.SuperVillain;

public class CIDriver {
	
	public static void main(String[] args) {
		
		ClassInspector.listPublicConstructor(SuperVillain.class);
		
		ClassInspector.listNonPublicField(SuperVillain.class);
		
		ClassInspector.listPublicMethods(SuperVillain.class);
	}

}

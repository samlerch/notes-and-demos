package com.revature.util;

import com.revature.exceptions.NotAGradeYearException;

public class UtilityMethods {

	public static void validateGradeYear(int gradeYear) throws NotAGradeYearException{
		
		if (gradeYear <=0 || gradeYear > 4) {
			throw new NotAGradeYearException("Please Enter a Grade between 1 - 4");
		}
	}
	
}

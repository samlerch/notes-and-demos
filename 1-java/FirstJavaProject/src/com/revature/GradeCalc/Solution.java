package com.revature.GradeCalc;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the maximum points for the quiz");
		double maxPoints = scan.nextDouble();
		
		// We'll use decimal format to format some things
		// There's a bunch of ways to do this
		
		DecimalFormat cleanDub = new DecimalFormat("0.#");
		
		// Create a prompt to ask for score
		System.out.println("Please enter the student's grade out of " + cleanDub.format(maxPoints));
		double score = scan.nextDouble();
		
		scan.close();
		
		double percent = calcPercent(score, maxPoints);
		
		// Let's clean up the percent
		String cleanPercent = cleanDub.format(percent);
		
		String letterGrade;
		
		if (percent >= 90) {
			letterGrade = "A";
		} else if (percent >= 80) {
			letterGrade = "B";
		} else if (percent >= 70) {
			letterGrade = "C";
		} else if (percent >= 60) {
			letterGrade = "D";
		} else {
			letterGrade = "F";
		}
		
		System.out.println("The student's letter grade is " + letterGrade + ". That's " + cleanPercent + "%!");
	}
	
	public static double calcPercent(double x, double y) {
		return (x/y)*100;
	}

}

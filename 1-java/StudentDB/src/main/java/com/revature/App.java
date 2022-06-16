package com.revature;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exceptions.NotAGradeYearException;
import com.revature.models.Student;
import com.revature.util.UtilityMethods;

public class App {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		// This is where the actual app logic will go
		
		// Step 1: is prompting the user for how many students to enter
		System.out.println("How many students are you entering into the Database?");
		
		// Step 2: take that capacity entered and use it to create an array of students
		int numOfStudents = scan.nextInt();
		
		Student[] students = new Student[numOfStudents];
		
		// Let's actually show the array once we create it
		System.out.println("This is what is inside the Student array with " + numOfStudents + " places.");
		System.out.println(Arrays.toString(students));
		
		// Step 3: Iterate over every student to enter in their information
		
		for (int i = 0; i < students.length; i++) {
			
			System.out.println("Please enter the first name");
			String firstName = scan.next();
			
			System.out.println("Please enter the last name");
			String lastName = scan.next();
			
			System.out.println("Please enter the grade year: \n1-Freshman \n2-Sophomore \n3-Junior \n4-Senior");
			
			int gradeYear = 0;
			boolean isValidInput = false;
			
			while (!isValidInput) {
				// Use a try catch block to do data validation with our input
				
				try {
					gradeYear = scan.nextInt();
					UtilityMethods.validateGradeYear(gradeYear);
					
					// DONT FORGET
					isValidInput = true;
				} catch (NotAGradeYearException e) {
					System.out.println(e.getMessage());
				} catch(InputMismatchException e) {
					System.out.println("Please enter a valid number");
				} finally {
					scan.nextLine(); // This allows us to repeat if necessary
				}
				
				
			}
			
			
			// Create student using constructor and amend original array
			
			Student s = new Student(firstName, lastName, gradeYear);
			
			students[i] = s;
		}
		
		
		// Let's take a look at the array afterwards
//		System.out.println("This is what is inside the Student array with " + numOfStudents + " places.");
//		System.out.println(Arrays.toString(students));
		
		// We can iterate using an enhanced for loop
		
		for (Student s: students) {
			System.out.println(s);
			s.enroll();
		}
		
		
		
		// Let's refactor and put everything inside a loop
		
		while(true) {
			
			// Let's create a prompt to find out what we want the user to do
			
			System.out.println("What would you like to do? \n"
								+ "Press 1 to view a student's status \n"
								+ "Press 2 to pay a student' tuition \n"
								+ "Press q to quit");
			
			// Capture their single input as a string
			
			String action = scan.next();
			
			
			// Create an if statement to handle actions
			
			if (action.equals("1")) {
				
				// Obtain student from identifier
				
				System.out.println("Please enter the Student's ID");
				int id = scan.nextInt();
				
				Student student = new Student();
				
				for(Student s: students) {
					if (id == Integer.parseInt(s.getStudentId())) {
						student = s;
					}
				}
				
				// Print Student information
				
				if (!student.getFirstName().equals("")) {
					System.out.println(student);
				} else {
					System.out.println("That's not a student!");
				}
				
			} else if (action.equals("2")) {
				
				//Obtain student from identifier
				
				System.out.println("Please enter the Student's ID");
				int id = scan.nextInt();
				
				Student student = new Student();
				
				for(Student s: students) {
					if (id == Integer.parseInt(s.getStudentId())) {
						student = s;
					}
				}
				
				// Use pay tuition to pay tuition
				
				if (!student.getFirstName().equals("")) {
					student.payTuition();
				} else {
					System.out.println("That's not a student!");
				}
				
				
			} else if (action.equalsIgnoreCase("q")) {
				System.out.println("Thanks for using the application");
				System.exit(0);
			} else {
				System.out.println("Not a valid input");
			}
		
		}
		
	}

}

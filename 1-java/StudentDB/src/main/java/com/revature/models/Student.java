package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	
	// Let's add a static identifier for the unique Id
	public static int GLOBAL_ID = 1000;
	private static Scanner scan = new Scanner(System.in);
	
	private String firstName;
	private String lastName;
	private int gradeYear; // 1 - freshman, 2 - sophomore ... to 4
	private String studentId; // This is grade year combined with a unique 4 digit number
	private List<Course> courses = new ArrayList<Course>(); // Student's depends on courses so we made course class first
	private double tuitionBalance = 0;
	
	
	public Student() {
		this.firstName = "";
		this.lastName = "";
	}
	
	// Constructor based off fields from user story
	public Student(String firstName, String lastName, int gradeYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeYear = gradeYear;
		
		setStudentId();
		
		System.out.println(firstName + " " + lastName + " " + gradeYear);
	}
	
	private void setStudentId() {
		GLOBAL_ID++;
		this.studentId = gradeYear + "" + GLOBAL_ID;
	}
	
	public void enroll() {
		// Enroll in classes
		// Update Tuition
		
		// Step 1: Create ArrayList of all courses for one student
		List<Course> coursesToAdd = new ArrayList<Course>();
		
		// Step 2: open up a while loop and let them add courses until some condition is changed
		boolean isDone = false;
		
		while (!isDone) {
			
			// Step 3: Prompt user to enter course name
			
			System.out.println("Please enter a course name \n"
								+ "or press q to quit");
			
			// Step 4: capture the course name and use that for some logic
			
			String courseName = scan.next();
			
			// Step 5a: If course is not called 'q' add course
			
			if (!courseName.equalsIgnoreCase("q")) {
				
				Course course = new Course(courseName);
				
				coursesToAdd.add(course);
				
				tuitionBalance += Course.COST_OF_COURSE;
				
				// This is necessary to repeat the loop
				
				scan.nextLine();
			
			
			// Step 5b: Otherwise quit
			} else {
				
				System.out.println("====== Quitting Enrollment ======");
				isDone = true;
			}
			
			// Set the student's courses equal to our list that we created here
			this.courses = coursesToAdd;
		}
		
		// Print everything out to check
		System.out.println("ENROLLED IN " + courses.toString());
	}
	
	public void viewBalance() {
		System.out.println("Your Balance is equal to " + tuitionBalance);
	}
	
	public void payTuition() {
		// Use this to pay tuition
		
		viewBalance();
		
		// Step 1: Prompt payment amount
		System.out.println("Please enter a payment amount");
		
		// Step 2: Capture as a double
		double payment = scan.nextDouble();
		
		// Step 3: Subtract from tuition amount
		tuitionBalance -= payment;
		
		// Step 4: Print out thank you message
		System.out.println("Thank you for your payment of " + payment);
		
		// Step 5: View Balance Again
		viewBalance();
		
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", gradeYear=" + gradeYear
				+ ", studentId=" + studentId + ", courses=" + courses + ", tuitionBalance=" + tuitionBalance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + gradeYear;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tuitionBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gradeYear != other.gradeYear)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		if (Double.doubleToLongBits(tuitionBalance) != Double.doubleToLongBits(other.tuitionBalance))
			return false;
		return true;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGradeYear() {
		return gradeYear;
	}

	public void setGradeYear(int gradeYear) {
		this.gradeYear = gradeYear;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public double getTuitionBalance() {
		return tuitionBalance;
	}

	public void setTuitionBalance(double tuitionBalance) {
		this.tuitionBalance = tuitionBalance;
	}
	

}

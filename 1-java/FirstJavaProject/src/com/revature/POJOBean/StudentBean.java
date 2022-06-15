package com.revature.POJOBean;

import java.io.Serializable;

// First thing is to implement the serializable interface
// It denotes metadata about the class and says it can be serialized
public class StudentBean implements Serializable{ // Let's Make a Bean

	// All fields need to be private
	private int studentId;
	private String studentName;
	
	
	// Necessary to have a no args constuctors
	public StudentBean() {
		super();
	}

	
	// Optionally we can create a constructor which takes in parameters
	public StudentBean(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}


	// Getters and Setters 
	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	
	
}

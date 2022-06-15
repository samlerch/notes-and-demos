package com.revature.POJOBean;

public class EmployeePOJO { // Plain old java object or pojo
	
	public String empName;
	public String empID;
	private double empSalary;
	
	
	public EmployeePOJO(String empName, String empID, double empSalary) {
		super();
		this.empName = empName;
		this.empID = empID;
		this.empSalary = empSalary;
	}


	public String getEmpName() {
		return empName;
	}


	public String getEmpID() {
		return empID;
	}


	public double getEmpSalary() {
		return empSalary;
	}
	
	

}

package com.revature.tests;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.revature.exceptions.NotAGradeYearException;
import com.revature.models.Course;
import com.revature.models.Student;
import com.revature.util.UtilityMethods;


public class StudentTest {
	
	// Let's add in some stubs
	// Stubs are dummy objects that you want to be able to repeatedly use
	static Student dummyStudent;
	static Course c1;
	static Course c2;
	static ArrayList<Course> courses;
	
	// Lets add methods for building the test suite and tearing down
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Setting Up the test suite");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Tear Down after class");
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up before each test");
		
		courses = new ArrayList<>();
		
		c1 = new Course("English 101");
		c2 = new Course("Biology 400");
		
		courses.add(c1);
		courses.add(c2);
	}
	
	@After
	public void tearDown() {
		System.out.println("Tearing down after every test");
		
		System.out.println();
		c1 = null;
		c2 = null;
		
		courses = null;
		dummyStudent = null;
		
		Student.GLOBAL_ID = 1000;
	}
	
	@Test
	
	public void testThisIsWorking() {
		int x = 2;
		int y = 3;
		
		int sum = (x+y);
		System.out.println("The sum is " + sum);
		
		// Use the Asserts to test the actual value
		Assert.assertEquals(5, sum); // Assertion
	}
	
	@Test
	public void testWhenInstantiateStudentThenAssignUniqueGlobalId() {
		
		dummyStudent = new Student("John", "Doe", 4);
		// If we instantiated right earlier, his id should bee 410001
		
		String actualId = dummyStudent.getStudentId();
		
		String expectedId = "41001";
		
		Assert.assertEquals(expectedId, actualId);
		
	}
	
	@Test
	public void testStudentObjectEquality() {
		dummyStudent = new Student("John", "Doe", 4);
		Student anotherStudent = new Student("John", "Doe", 4);
		
		System.out.println(dummyStudent);
		System.out.println(anotherStudent);
		
		dummyStudent.setStudentId("1");
		anotherStudent.setStudentId("1");
		
		Assert.assertTrue(dummyStudent.equals(anotherStudent));
	}
	
	@Test
	public void testSetStudentIdCreatesUniqueId() {
		dummyStudent = new Student("John", "Doe", 4);
		Student anotherStudent = new Student("John", "Doe", 4);
		
		Assert.assertNotEquals(dummyStudent.getStudentId(), anotherStudent.getStudentId());
	}
	
	@Test
	public void testStudentObjectEqualityNegative() {
		dummyStudent = new Student("John", "Doe", 4);
		Student anotherStudent = new Student("John", "Doe", 4);
		
		System.out.println(dummyStudent);
		System.out.println(anotherStudent);
		
//		dummyStudent.setStudentId("1");
//		anotherStudent.setStudentId("1");
		
		Assert.assertFalse(dummyStudent.equals(anotherStudent));
	}
	
	//Lets test for an exception
	
	@Test(expected = NotAGradeYearException.class)
	public void testBadGradeYearExceptionIsThrown() {
		int badGradeYear = -1;
		
		UtilityMethods.validateGradeYear(badGradeYear);
	}
	

}

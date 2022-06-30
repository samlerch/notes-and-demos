package com.revature.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAPI {
	
	public static void main(String[] args) {
		// There are three main classes we use for the current date and/or time
		
		// Local date allows us to retrieve the date
		LocalDate date = LocalDate.now();
		System.out.println("The current date is " + date);
		
		LocalDate date2 = LocalDate.of(2022,6,30);
		System.out.println("Our created date is " + date2 );
		
		// LocalTime allows to work with the current time
		LocalTime time = LocalTime.now();
		System.out.println("The current time is " + time);
		
		// To get the current date and time
		// Let's use LocalDateTime
		
		LocalDateTime current = LocalDateTime.now();
		System.out.println("Current date and time: " + current);
		
		// To print in a particular format
		// Check the notes for W3 page on formatting
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		// Format our date using the formatter
		
		String formattedDateTime =current.format(format);
		
		System.out.println("Current Date and Time formatted: " + formattedDateTime);
		
		// Printing months days and seconds
		Month month = current.getMonth();
		
		int day = current.getDayOfMonth();
		int seconds = current.getSecond();
		
		System.out.println("Month: " + month + " day: "+ day + " seconds: " + seconds);
		
		
		// We can also do something like set a date but with the current time
		
		LocalDateTime specificDate = current.withDayOfMonth(24).withYear(2012);
		
		String specificFormattedDate = specificDate.format(format);
		
		System.out.println("Specific date with current time: " + specificFormattedDate);
	}

}

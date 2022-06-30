package com.revature.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class ChronoUnits {
	
	public static void main(String[] args) {
		
		
		LocalDate date1 = LocalDate.now();
		
		LocalDate date2 = LocalDate.of(2012, Month.DECEMBER, 21);
		
		Period gap = Period.between(date2, date1);
		
		System.out.println("The gap between theses date is a period of " + gap);
		
		System.out.println(gap.getYears());
		
		// We can also mess with durations
		
		LocalTime time1 = LocalTime.now();
		
		System.out.println("Current time: " + time1);
		
		//Let's add 5 hours of time
		
		Duration fiveHours = Duration.ofHours(5);
		
		// Let's add this onto our localtime
		
		LocalTime time2 = time1.plus(fiveHours);
		
		System.out.println("The time is 5 hours is: " + time2);
		
		// Let's mess around with ChronoUnits
		
		LocalDate date = LocalDate.now();
		System.out.println("Current Date: " + date);
		
		// Let's add 2 years to the current date
		LocalDate year = date.plus(2, ChronoUnit.YEARS);
		
		System.out.println("Date in 2 years is: "+ year);
		
		// Add 1 month to the current date
		
		LocalDate nextMonth = date.plus(1, ChronoUnit.MONTHS);
		
		System.out.println("Next Month the date is:" + nextMonth);
		
		// Let's look at what happens when the next month doesn't have that day
		LocalDate test = LocalDate.of(2022,1,31);
		
		LocalDate test2 = test.plus(1,ChronoUnit.MONTHS);
		
		System.out.println(test2);
		
		System.out.println(test2.plus(1,ChronoUnit.MONTHS));
	}

}

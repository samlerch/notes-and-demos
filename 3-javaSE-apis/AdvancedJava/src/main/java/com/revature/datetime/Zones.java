package com.revature.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Zones {
	
	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
	    DateTimeFormatter format1 =
	      DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	     
	    String formattedCurrentDate = date.format(format1);
	     
	    System.out.println("formatted current Date and"+
	                      " Time : "+formattedCurrentDate);
	    
	    // To get the current zone
	    ZonedDateTime currentZone = ZonedDateTime.now();
	    System.out.println("The current zone is " + currentZone.getZone());
	    
	    // Get the time zone of a specific place using the withZoneSameInstant(): this is used
	    // to return a copy of this date-time with a different time zone
	    
	    ZoneId tokyo = ZoneId.of("Asia/Tokyo");
	    
	    ZonedDateTime tokyoZone = currentZone.withZoneSameInstant(tokyo);
	    
	    System.out.println("Tokyo time is " + tokyoZone);
	    
	    String formattedTokyoTime = tokyoZone.format(format1);
	    
	    System.out.println("The formatted time in Tokyo is " + formattedTokyoTime);
	}

}

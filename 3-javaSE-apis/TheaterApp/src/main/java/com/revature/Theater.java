package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Theater {

	private final String theaterName;
	private List<Seat> seats = new ArrayList<>();

	// Let's construct our theater
	public Theater(String theaterName, int numRows, int seatsPerRow) {

		this.theaterName = theaterName;

		// Let's use the rows and seats to construct our theater

		int lastRow = 'A' + (numRows - 1); // This will give use the value for our last row

		// Let's use a for loop to create our seats

		for (char row = 'A'; row <= lastRow; row++) {

			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				Seat seat = new Seat(row + String.format("%02d", seatNum)); // First seat would be A01
				seats.add(seat);
			}
		}
	}

	// Let's create a basic brute force for reserving seats

	public boolean reserveSeatBruteForce(String seatNumber) {

		// Let's iterate over every seat until we find the seat we're looking for

		Seat requestedSeat = null;

		// Searching for the seat brute force method
		for (Seat seat : seats) {

			System.out.println("Searching.....");

			if (seat.getSeatNumber().equals(seatNumber)) {
				// Set the requested seat to seat
				requestedSeat = seat;
				// Then break
				break;
			}

		}

		// Let's reserve the seat

		// If the requested seat is still null, return false
		if (requestedSeat == null) {

			System.out.println("Sorry there is no seat " + seatNumber);
			return false;
		}

		// Return the requestedSeat.reserve();

		return requestedSeat.reserve();
	}

	// Let's create a binary method to reserve seats

	public boolean reserveSeatBinary(Seat seatToReserve) {
		int low = 0;
		int high = seats.size() - 1; // Equal to number of seats in theater

		while (low <= high) {

			System.out.println("Searching....");
			int mid = (low + high) / 2; // Finds the middle index
			// Get the seat at the middle index

			Seat midSeat = seats.get(mid);

			// Now we can use our compareTo method to check the seats value versus our
			// requested seat
			int comparison = midSeat.compareTo(seatToReserve);

			if (comparison < 0) {
				low = mid + 1;
			} else if (comparison > 0) {
				high = mid - 1;
			} else {
				return seats.get(mid).reserve();
			}
		}

		System.out.println("There is no seat " + seatToReserve.getSeatNumber());
		return false;
	}
	
	// Alternatively we could just have compared the string in this binary method
	// And skipped a couple steps
	
	public boolean reserveSeatBinary(String seatToReserve) {
		int low = 0;
		int high = seats.size() - 1; // Equal to number of seats in theater

		while (low <= high) {

			System.out.println("Searching....");
			int mid = (low + high) / 2; // Finds the middle index
			// Get the seat at the middle index

			Seat midSeat = seats.get(mid);

			// Now we can use our compareTo method to check the seats value versus our
			// requested seat
			int comparison = midSeat.getSeatNumber().compareTo(seatToReserve);

			if (comparison < 0) {
				low = mid + 1;
			} else if (comparison > 0) {
				high = mid - 1;
			} else {
				return seats.get(mid).reserve();
			}
		}

		System.out.println("There is no seat " + seatToReserve);
		return false;
	}

	public void getSeats() {

		// Goal is to print all the seats when called

//		for (Seat s : seats) {
//			System.out.println(s);
//		}
		
		// Let's use a lambda expression to do the same thing
		
		// ====== Single Line Lambda =======
//		seats.forEach(seat -> System.out.println(seat));
		
		// We can also do a multiline lambda function like so
		
//		seats.forEach((seat) -> {
//			// This is a multi line lambda
//			
//			System.out.println(seat);
//			System.out.println("Multiple Lines of code");
//		});
		
		
		// Theres also a couple other ways to do this
		
		// Method References
		// There's an article on how to do this in the notes for methods with varying modifiers
		
//		seats.forEach(System.out::println); // Calls the class and then the method from the class to act on each seat
		
		// Finally we can also use an anonymous class
		// Since a consumer interface is the only thing I need here I can implement
		// its accept method by the use of an anonymous class implementing the consumer interface
		
		seats.forEach(new Consumer<Seat>() {

			@Override
			public void accept(Seat t) {
				System.out.println(t);
				
			}
			
			
		});
		
	}

	// Let's create a nested class to group seats inside theater
	// This nested class is used to increase encapsulation
	// Meaning more readable and maintainable code

	private class Seat implements Comparable<Seat> {
		private final String seatNumber; // A03, H05, G11.....
		private boolean reserved = false;

		// Final instance variables must be initialized in a constructor like so
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		// Let's create a reserve method to toggle reserved
		public boolean reserve() {
			if (!this.reserved) {

				this.reserved = true;

				System.out.println("Reservation of seat " + this.seatNumber + " confirmed.");

				return true;
			} else {
				System.out.println("Sorry it's reserved!");
				return false;
			}
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean isReserved() {
			return reserved;
		}

		@Override
		public String toString() {
			return seatNumber;
		}

		@Override
		public int compareTo(Seat anotherSeat) {
			// This utilizes the String method for compare to
			// CompareTo returns 0 if equal, -1 if less than, 1 if greater that
			return this.seatNumber.compareTo(anotherSeat.getSeatNumber());
		}
	}
}

package com.revature.searching;

public class AlgorithmDriver {
	
	public static void main(String[] args) {
		int[] arr = {1,4,23,52,64,65,66,89};
		
		int target = 65;
		
		linearSearch(arr, target);
		System.out.println("=====================");
		
		binarySearch(arr, target);
		System.out.println("======================");
		
		// call recursive search to handle search
		// Pass in the array and pass in the minimum index and maximum index
		recSearch(arr, 0, arr.length-1, target);
		System.out.println("=========================");
	}
	
	public static int linearSearch(int[] arr, int target) {
		
		for(int i = 0; i< arr.length; i++) {
			System.out.println("Searching....");
			
			if (arr[i] == target) {
				System.out.println("Found the target at index: " + i);
				return i;
			}
		}
		
		return -1;
	}
	
	public static int binarySearch(int[] arr, int target) {
	    int min = 0;
	    int max = arr.length - 1;
	    while (min <= max) {
	    	
	    	System.out.println("Searching....");
	        
	        int mid = (min + max) / 2;
	        
	        if (target < arr[mid]) { // if the target value is less than
	            max = mid - 1; // the midpoint, we discard the RHS
	        } else if (target > arr[mid]) {
	            min = mid + 1; // otherwise we discard the LHS
	        } else {
	        	System.out.println("Found target at index " + mid);
	            return mid;
	        }
	    }
	    return -1;
	}
	
	
	/* Recursive Method to search x in arr[l..r] */
    static int recSearch(int arr[], int min, int max, int target)
    {
    	
         if (max < min) {
            return -1;
         }
         System.out.println("Searching Recursively");
         // Check minimum in array
         // If minimum == target return the minimum
         if (arr[min] == target) {
        	 System.out.println("Target found at index: " + min);
            return min;
         }
         System.out.println("Searching Recursively");
         
         //Check maximum in array
         // If maximum == target return the maximum
         if (arr[max] == target) {
        	 System.out.println("Target found at index: " + max);
            return max;
            }
         
         // We put searching twice now because we check the bottom and the top array in one "loop"
         // If this doesn't find it, make the minimum a little larger and the maximum a bit smaller
         // Then call the method again with the new min and max
         return recSearch(arr, min+1, max-1, target);
    }

}

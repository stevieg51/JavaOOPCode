package sgordonmod4;

import java.text.DecimalFormat;

public class SequenceDriver {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("##.#");
		int[] nums = {1,3,5,9,12,15,4,7,4,2,12};
		Sequence am = new Sequence(nums);
		
		System.out.println("The original array:");
		System.out.println(am.toString());
		
				
		System.out.println("\nSwapping first and last:");
		am.swapFirstAndLast();
		System.out.println(am.toString());
		
		System.out.println("\nShifting all elements to the right and the last becomes first:");
		System.out.println("Code must have a single for loop");
		am.shift();
		System.out.println(am.toString());
		
		System.out.println("\nAll of the even values");
		int[] evenValues = am.evens();
		print(evenValues);
		
		System.out.println("\nThe shifted array with the middle element(s) removed.");
		am.removeMiddle();
		System.out.println(am.toString());
		
		System.out.println("\nRepeated - the shifted array with the middle element(s) removed.");
		am.removeMiddle();
		System.out.println(am.toString());
		
		System.out.println("\nA check to see if the array is sorted");
		boolean ans = am.inOrder();
		if (ans ==true)
			System.out.println("All elements are in order");
		
			
		System.out.println("\nFind the second largest element");
		int second = am.findSecondLargest();
		System.out.println("The second largest value was "  + second);
		
		System.out.println("\nSum two arrays.  Test it with both of the arrays below");
		
		int[] other1 = {2,4,6};
		int[] other1Added = am.sum(other1);
		System.out.println("Summing with {2,4,6} ");
		print(other1Added);
		
		int[] other2 = {2,4,6,1,1,4,5,6,7,7,8,9};
		int[] other2Added = am.sum(other2);
		System.out.println("Summing with {2,4,6,1,1,4,5,6,7,7,8,9}");
		print(other2Added);
		
		
		

	}
	
	public static void print(int[] arr) {
		for (int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	

}

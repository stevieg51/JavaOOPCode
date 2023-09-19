package sgordonmod4;

import java.util.Arrays;

public class Sequence {

	private int[] values;

	public Sequence() {

	}

	public Sequence(int n) {
		values[values.length - 1] = n;
	}

	public Sequence(int n[]) {
		values = n;
	}

	public String toString() {
		// need to fix
		return Arrays.toString(values);
	}

	public void swapFirstAndLast() {
		// works
		int lastElem = values[values.length - 1];
		values[values.length - 1] = values[0];
		values[0] = lastElem;
	}

	public void shift() {
		// works
		int temp = values[values.length - 1];
		for (int i = values.length - 1; i > 0; i--) {
			values[i] = values[i - 1];
		}
		values[0] = temp;

	}

	public int[] evens() {
		// need to make this so the length of the array increases with amount, otherwise
		// it's done
		int[] evenNums = new int[5];
		int index = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 0) {
				evenNums[index] = values[i];
				index++;
			}
		}
		return evenNums;
	}

	public void removeMiddle() {
		// changing the values of the middle elements to 0, not neccecarilly removing
		// the cell, check to see if this is right, check to see if index of 0 is
		// counted
		int arrLength = values.length;
		if (arrLength % 2 != 0) {
			int indexToRemove = (arrLength + 1) / 2 - 1;
			values[indexToRemove] = 0;
		} else if (arrLength % 2 == 0) {
			int removeIndex = arrLength / 2;
			values[removeIndex] = 0;
			values[removeIndex + 1] = 0;
		}
//		for (int i = 0; i < values.length; i++) {
//			int[] temp = new int[values.length - 1];
//			int index = 0;
//			if (values[i] != 0)
//			{
//				temp[index] = values[i];
//				index++;
//			}
//			values = temp;
//		}
	}

	public boolean inOrder() {
		String done = "no";
		int i = 0;
		boolean ordered = true;

		// might have a problem with the loop going out of the arrays bounds

		while (done.equals("no")) {
			int lastVal = values[i];
			int firstUnsorted = 0;
			if (values[i + 1] < lastVal) {
				firstUnsorted = values[i + 1];
				done = "yes";
				ordered = false;
			}
			i++;
		}
		return ordered;
	}

	public int findSecondLargest() {
		// works
		int largest = values[0];
		int secondLargest = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] > largest) {
				secondLargest = largest;
				largest = values[i];
			} else if (values[i] > secondLargest) {
				secondLargest = values[i];
			}
		}
		return secondLargest;
	}

	public int[] sum(int[] other) {
		// no way it is this simple
		int[] newArr = new int[20];
		for (int i = 0; i < values.length; i++) {
			int index = 0;
			newArr[index] = values[i] + other[i];
			index++;
		}
		return newArr;
	}

	public int[] getValues() {
		return null;
	}

	public void setValues(int[] n) {

	}

}

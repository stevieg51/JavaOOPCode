package sgordonmod7csc222;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sgordonm7q1.FileLoc;

public class TestScores { // need to fix it printing out the values with frequency > 1 multiple times in
							// printFrequency/Distributionloop

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> testScores = loadData();
		Collections.sort(testScores);
		removeBad(testScores);
		printRatings(testScores);
		System.out.println();

		printDistribution(testScores);

		printFrequency(testScores);
		double average = getAverage(testScores);

		System.out.println("The average value is: " + average);

		sc.close();
		System.exit(0);
	}

	public static void removeBad(ArrayList<Integer> scores) { 
		System.out.println("The Bad Values: ");
		int bad = 0;
		for (int i = 0; i < scores.size(); i++) {
			if (scores.get(i) > 100 || scores.get(i) < 0) {
				bad++;
				System.out.println(scores.get(i));
			scores.remove(i);
			}
		}
		if (bad == 0) { 
			System.out.println("NONE!");
		}
		
	}

	public static ArrayList<Integer> loadData() {
		Scanner sc = new Scanner(System.in);

		String fileName = FileLoc.pickLocRead();

		File file = new File(fileName);
		Scanner inputFile = null;
		ArrayList<Integer> testScores = new ArrayList<>();
		try {
			inputFile = new Scanner(file);

			while (inputFile.hasNextLine()) {
				int theNum = inputFile.nextInt();
				testScores.add(theNum);
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.out.println(ioe.getMessage());
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();
		}
		return testScores;
	}

	public static int scoreFrequency(ArrayList<Integer> scores, int theNum) {
		int frequency = 0;
		for (int i = 0; i < scores.size(); i++) {
			if (theNum == scores.get(i)) {
				frequency++;
			}
		}

		return frequency;
	}

	public static double getAverage(ArrayList<Integer> scores) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < scores.size(); i++) {
			sum += scores.get(i);
			count++;
		}
		double average = sum / count;
		return average;
	}

	public static void printRatings(ArrayList<Integer> scores) {
		System.out.println();
		System.out.println("Ratings:");
		int countPerLine = 0;
		for (int i = 0; i < scores.size(); i++) {
			int theInt = scores.get(i);
			System.out.print(theInt + " ");
			countPerLine = countPerLine + 1;
			if (countPerLine >= 10) {
				System.out.println();
				countPerLine = 0;
			}
		}

	}

	public static void printFrequency(ArrayList<Integer> scores) {
		System.out.println();
		System.out.println("The following is a frequency of values: ");
		for (int i = 0; i < scores.size(); i++) {
			int theNum = scores.get(i);
			int frequency = scoreFrequency(scores, theNum);
			System.out.println(theNum + " - " + frequency);

		}
	}

	public static void printDistribution(ArrayList<Integer> scores) {
		System.out.println();
		System.out.println("The following is a distribution of values: ");
		int firstTen = 0;
		int secondTen = 0;
		int thirdTen = 0;
		int fourthTen = 0;
		int fithTen = 0;
		int sixthTen = 0;
		int seventhTen = 0;
		int eigthTen = 0;
		int ninthTen = 0;
		int tenthTen = 0;
		int hundred = 0;
		for (int i = 0; i < scores.size(); i++) {
			int theNum = scores.get(i);

			if (theNum >= 0 && theNum <= 9) {
				firstTen++;
			} else if (theNum >= 10 && theNum <= 19) {
				secondTen++;
			} else if (theNum > 20 && theNum <= 29) {
				thirdTen++;
			} else if (theNum >= 30 && theNum <= 39) {
				fourthTen++;
			} else if (theNum >= 40 && theNum <= 49) {
				fithTen++;
			} else if (theNum >= 50 && theNum <= 59) {
				sixthTen++;
			} else if (theNum >= 60 && theNum <= 69) {
				seventhTen++;
			} else if (theNum >= 70 && theNum <= 79) {
				eigthTen++;
			} else if (theNum >= 80 && theNum <= 89) {
				ninthTen++;
			} else if (theNum >= 90 && theNum <= 99) {
				tenthTen++;
			} else {
				hundred++;
			}

		}
		System.out.println("00-09 " + firstTen);
		System.out.println("10-19 " + secondTen);
		System.out.println("20-29 " + thirdTen);
		System.out.println("30-39 " + fourthTen);
		System.out.println("40-49 " + fithTen);
		System.out.println("50-59 " + sixthTen);
		System.out.println("60-69 " + seventhTen);
		System.out.println("70-79 " + eigthTen);
		System.out.println("80-89 " + ninthTen);
		System.out.println("90-99 " + tenthTen);
		System.out.println("100 " + hundred);
	}

}

package sgordonmod4;

import java.text.NumberFormat;
import java.util.Scanner;

public class ConcertSales {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getCurrencyInstance();

		int tickets[][] = { { 300, 400, 500, 500, 500, 500, 500, 500, 400, 400 },
				{ 200, 300, 300, 400, 500, 500, 400, 300, 300, 200 },
				{ 100, 100, 150, 200, 200, 200, 150, 150, 100, 100 },
				{ 100, 100, 150, 200, 200, 200, 150, 100, 100, 100 }, { 50, 50, 75, 75, 75, 85, 75, 75, 50, 50 },
				{ 50, 50, 75, 75, 75, 85, 75, 75, 50, 50 }, { 30, 30, 30, 40, 40, 40, 40, 30, 30, 30 },
				{ 20, 20, 20, 20, 20, 20, 20, 20, 20, 20 } };

		Concert theTickets = new Concert(tickets);

		int theTotal = theTickets.getTotal();
		System.out.println("The total value if you sell all the seats is: " + nf.format(theTotal));

		int numElem = theTickets.getElementCount();
		System.out.println("The total number of seats in our theatre is: " + numElem);

		double average = theTickets.getAverage();
		System.out.println("The average cost of a ticket in our theatre is: " + nf.format(average));
		System.out.println();

		System.out.println("Row summary:");
		for (int i = 0; i < tickets.length; i++) {
			double rowAvg = theTickets.getRowAverage(i);
			System.out.println("Avaerage cost of a ticket in row " + (i + 1) + ": " + nf.format(rowAvg));
		}
		System.out.println();

		System.out.println("Now let's sell some of these tickets! ");
		System.out.println();
		System.out.println("The theatre: (any seat with a zero is sold) ");
		theTickets.printArray();

	}

//	private static double sellTickets(Concert) {
//		
//	}

}

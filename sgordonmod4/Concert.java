package sgordonmod4;

import java.text.NumberFormat;

public class Concert {

	private int[][] tickets;

	public Concert() {

	}

	public Concert(int[][] ticket) {
		tickets = ticket;
	}

	public int getTotal() {
		int total = 0;
		for (int row = 0; row < tickets.length; row++) {
			for (int col = 0; col < tickets[0].length; col++)
				total = total + tickets[row][col];
		}
		return total;
	}

	public int getElementCount() {
		int elementCount = 0;
		for (int row = 0; row < tickets.length; row++) {
			for (int col = 0; col < tickets[0].length; col++)
				elementCount = elementCount + 1;
		}
		return elementCount;
	}

	public double getAverage() {
		int total = getTotal();
		int seats = getElementCount();
		double average = total / seats;
		return average;

	}

	public double getRowAverage(int rowNum) {
		int total = 0;
		double average = 0;

		for (int row = rowNum; row < rowNum + 1; row++) {
			for (int col = 0; col < tickets[row].length; col++) {
				total += tickets[row][col];
			}
			average = total / tickets[row].length;
			total = 0;
		}
		return average;
	}

	public void printArray() {
		for (int row = 0; row < tickets.length; row++) {
			for (int col = 0; col < tickets[0].length; col++)
				System.out.print(tickets[row][col] + "  ");
			System.out.println();
		}
	}

//	public int sellTicket(int n, int n2) {
//
//	}
//
	public int[][] getTickets() {
		return tickets;
	}
}
//
//	public void setTickets(int[][]) {
//		
//	}
//}

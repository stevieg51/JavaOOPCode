package sgordonmod5csc222;

import java.util.*;
import java.text.*;

//only other thing(s) that need to be done is input validation
public class TimeShareDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<TimeShare> timeShare = new ArrayList<TimeShare>();
		ArrayList<TSReservation> reservations = new ArrayList<TSReservation>();
		int loopNum = 0;
		Boolean more = true;

		loadNewData(timeShare, customers);

		while (more) {

			System.out.println("Do you want to (1) rent a time share or (2) check a time sharesback in?");
			int custChoice = sc.nextInt();

			if (custChoice == 2) {
				printRentals(reservations);

				System.out.println(
						"Which does ye want to return? There is a hidden return fee for the price of a ice cream cone from the Rehobeth Beach boardwalk!!");
				int rentalReturn = sc.nextInt();
				TSReservation trueReturn = reservations.get(rentalReturn - 1);
				timeShare.add(trueReturn.getTimeShare());
				customers.add(trueReturn.getCust());
			} else {

				showAllCustomers(customers);
				System.out.println();

				System.out.println("Choose your pokemon!.. playe.. cutsomer! Choose the customer(1-5): ");
				int theCustomer = sc.nextInt();
				Customer trueCust = customers.get(theCustomer - 1);
				customers.remove(theCustomer - 1);
				System.out.println();

				showTimesShares(timeShare);
				System.out.println("Choose the humble abode you wish to reside in(1-4): ");
				int theAbode = sc.nextInt();
				TimeShare trueShare = timeShare.get(theAbode - 1);

				System.out.println("How many passings of night shall thy be residing here?: ");
				int numDays = sc.nextInt();

				reservations.add(new TSReservation(trueCust, trueShare, numDays));
				timeShare.remove(theAbode - 1);

				TSReservation currentReservation = reservations.get(loopNum);
				System.out.println(currentReservation.toString());
				System.out.println();
				loopNum++;

			}
			System.out.println();
			System.out.println("More Reservations/Rentals?: (true or false)");
			more = sc.nextBoolean();
		} // end while
		System.out.println("Thank you for yoru time!");

	}

	// This method loads the pre-set data into the Customer and Auto ArrayLists
	public static void loadNewData(ArrayList<TimeShare> a, ArrayList<Customer> c) {
		a.add(new TimeShare("Phoenix-1", 2, 120.00));
		a.add(new TimeShare("San Diego-1", 1, 135.00));
		a.add(new TimeShare("Phoenix-2", 1, 110.00));
		a.add(new TimeShare("Virginia Beach-1", 3, 145.00));

		c.add(new Customer("Jose Altuve", false));
		c.add(new Customer("Bruce Springsteen", true));
		c.add(new Customer("Diana Taurasi", true));
		c.add(new Customer("Queen Elizabeth", true));
		c.add(new Customer("Mike Moustakas", true));
	}

	public static void showTimesShares(ArrayList<TimeShare> timeShares) {
		System.out.println("Available time share locations: ");
		for (int i = 0; i < timeShares.size(); i++) {
			TimeShare currentShare = timeShares.get(i);
			System.out.println((i + 1) + ": " + currentShare.toString());
		}

	}

	public static void showAllCustomers(ArrayList<Customer> customers) {
		System.out.println("Customers:");
		for (int i = 0; i < customers.size(); i++) {
			Customer currentCust = customers.get(i);
			currentCust.setCustId(i);
			System.out.println((i + 1) + ": " + currentCust.toString());
		}
	}

	public static void printRentals(ArrayList<TSReservation> reservations) {
		System.out.println("Previous time shares:");
		for (int i = 0; i < reservations.size(); i++) {
			TSReservation currentReservation = reservations.get(i);
			System.out.println((i + 1) + ": " + currentReservation.toString());
		}
	}
}

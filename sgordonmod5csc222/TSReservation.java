package sgordonmod5csc222;

import java.text.NumberFormat;

public class TSReservation {

	// the Rental class has four fields

	private Customer cust;
	private TimeShare timeShare;
	private int numDays;
	private char discount;
	private double rentAmt;

	public TSReservation() {

	}

	public TSReservation(Customer c, TimeShare ts, int days) {
		cust = c;
		timeShare = ts;
		numDays = days;
		setRentalCost();
	}

	// need constructors
	// your full constructors needs to call the setRentalCost() method so it can
	// set both the rentAmt and discount fields

	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String string;
		string = cust.toString() + " rented ";
		string = string + timeShare.toString() + " for " + numDays + " days.";
		string = string + "\n   The cost was " + nf.format(rentAmt) + "\n";
		switch (discount) {
		case 'B':
			string = string
					+ "This person was a premier memeber and rented over six days and received a a 30% discount";
			break;
		case 'G':
			string = string + "This person was a premier member and received a a 10% discount";
			break;
		case 'D':
			string = string + "This person rented over six days and received a 20% discount";
			break;
		case 'N':
			string = string + "This person did not qualify for a discount";

		}

		return string;
	}

	// TO DO!!!the setRentalCost is where the cost is set
	// you also set the discount code here for the rental
	// so this method sets two fields

	// N = none P = premier D = days B = both
	// get 20% discount for rentals of a week or more
	// get 10% more (30% total) if they are a premier member
	public void setRentalCost() {
		double costWithoutDiscount = timeShare.getCostPerNight() * timeShare.getNumBedrooms();

		if (numDays < 7 && !cust.isPremier()) {
			rentAmt = costWithoutDiscount;
			discount = 'N';
		} else if (numDays >= 7 && cust.isPremier()) {
			double theDiscount = costWithoutDiscount * .30;
			rentAmt = costWithoutDiscount - theDiscount;
			discount = 'B';
		} else if (numDays >= 7 && !cust.isPremier()) {
			double theDiscount = costWithoutDiscount * .20;
			rentAmt = costWithoutDiscount - theDiscount;
			discount = 'D';
		} else if (cust.isPremier() && numDays < 7) {
			double theDiscount = costWithoutDiscount * .10;
			rentAmt = costWithoutDiscount - theDiscount;
			discount = 'P';
		}

	}
	

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public TimeShare getTimeShare() {
		return timeShare;
	}

	public void setTimeShare(TimeShare timeShare) {
		this.timeShare = timeShare;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	public char getDiscount() {
		return discount;
	}

	public void setDiscount(char discount) {
		this.discount = discount;
	}

	public double getRentAmt() {
		return rentAmt;
	}

	public void setRentAmt(double rentAmt) {
		this.rentAmt = rentAmt;
	}

}
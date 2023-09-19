package sgordonmod7csc222;

import java.text.*;

/**
 * Abstract Insurance Class used to to describe and define the methods needed
 * for a instance of insurance
 * 
 * @author sgordon and db2admin
 **/

public abstract class Insurance implements Comparable<Insurance> {

	// NOTE: these fields are protected!!!!! If I am to inherit
	// these , they must be protected (private allows NO other classes
	// to use them) - protected means this class and any class that inherits
	// from this one can use these
	/**
	 * Used to hold the customer object
	 */
	protected Customer customer;
	/**
	 * Used to hold the yearlyRate of the insurance policy
	 */
	protected double yearlyRate;
	/**
	 * A unique number for each insurance policy
	 */
	protected int policyNumber;

	// for currency output
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	/**
	 * a static variable used to make the insurance id unique
	 */
	public static int num = 1000;

	/**
	 * Full Constructor - used to create a new insurance policy Creates a unique id
	 * 
	 * @param custLast - the Customer object
	 */
	public Insurance(Customer cust) {
		customer = cust;
		policyNumber = num;
		num++;

	}

	/**
	 * used for reading from a file where policy number and rate already set read
	 * the id - do not create a new one
	 * 
	 * @param cust    - Customer object
	 * @param polNum- The policy number
	 * @param yrRate  - The yearly rate of the insurance
	 */
	public Insurance(Customer cust, int polNum, double yrRate) {
		customer = cust;
		policyNumber = polNum;
		yearlyRate = yrRate;

	}

	/**
	 * empty constructor but still creates a unique id for the policy
	 */
	public Insurance() {
		policyNumber = num;
		num++;
	}

	/**
	 * Used to set the yearlyRate
	 */
	public abstract void calcRate();

	/**
	 * used to display the Insurance class fields as a String output while
	 * displaying the object's toString method
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return (customer.toString() + " with policy number " + policyNumber + " has a yearly rate of "
				+ currency.format(yearlyRate));
	}

	public String toStringF() {
		return customer.toStringF() + "|" + policyNumber + "|" + currency.format(yearlyRate) + "|" + num;
	}

	/**
	 * used to get the customer object
	 * 
	 * @return a Customer object that is a customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * used to get the policy number
	 * 
	 * @return a int that is the policy number
	 */
	public int getPolicyNumber() {
		return policyNumber;
	}

	/**
	 * used to get the yearly rate
	 * 
	 * @return a double that is the yearly rate
	 */
	public double getYearlyRate() {
		return yearlyRate;
	}

	/**
	 * used to set the customer object
	 * 
	 * @param Customer- the customer object
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * used to set the policy number
	 * 
	 * @param int- the policy number
	 */
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	/**
	 * used to set the yearly rate
	 * 
	 * @param double- the yearly rate
	 */
	public void setYearlyRate(double yearlyRate) {
		this.yearlyRate = yearlyRate;
	}

	/**
	 * used to define how to compare an insurance object based on it's policy number
	 * 
	 * @param Insurance- the insurance object
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 **/
	public int compareTo(Insurance ins) {
		if (ins.getPolicyNumber() < this.policyNumber)
			return 1;
		else if (ins.getPolicyNumber() > this.policyNumber)
			return -1;
		else
			return 0;
	}

}

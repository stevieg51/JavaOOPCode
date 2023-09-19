package sgordonmod7csc222;

// "Extends" means inherit all the methods and fields from Insurance
public class HealthInsurance extends Insurance {

	private int numDependents;

	public HealthInsurance(Customer cust, int dependents) {
		super(cust);
		this.numDependents = dependents;
		calcRate();
	}

	public HealthInsurance(Customer cust, int polNum, double yrRate, int numD) {
		super(cust, polNum, yrRate);
		numDependents = numD;
	}

	public HealthInsurance() {
	}

	public void calcRate() {
		yearlyRate = 500 * numDependents;
	}

	// we override the toString method from the Insurance class
	public String toString() {
		return super.toString() + " for health insurance. The number of dependents is " + getNumDependents();
	}
	
	public String toStringF()
	{
		return "HLT|" + super.toStringF() + "|" + numDependents;
	}

	public int getNumDependents() {
		return numDependents;
	}

	public void setNumDependents(int numDependents) {
		this.numDependents = numDependents;
	}

}

package sgordonmod7csc222;

import java.text.NumberFormat;

public class LifeInsurance extends Insurance {

	private int amtIns;
	private int age;

	NumberFormat nf = NumberFormat.getCurrencyInstance();

	// full constructor. Let super (Insurance) set any fields that really came from
	// there.
	// Make certain to also set the rate
	public LifeInsurance(Customer cust, int amtIns, int custAge) {
		super(cust);
		this.amtIns = amtIns;
		age = custAge;
		calcRate();

	}

	// empty constructor
	public LifeInsurance() {
	}

	// full constructor if reading from a file
	public LifeInsurance(Customer cust, int polNum, double yrRate, int amtIns, int custAge) {
		super(cust, polNum, yrRate);
		this.amtIns = amtIns;
		age = custAge;
	}

	public void calcRate() {
		if (age > 40)
			yearlyRate = amtIns * .005 * 2;
		else
			yearlyRate = amtIns * .005;
	}

	public String toString() {
		return super.toString() + " for life insurance. The age of the customer is  " + age
				+ " \n and the amount of insurance they wish to have is " + nf.format(amtIns) + ".";
	}
	
	public String toStringF()
	{
		return "LFE|" + super.toStringF() + "|" + nf.format(amtIns) + "|" + age;
	}

	public int getAmtIns() {
		return amtIns;
	}

	public void setAmtIns(int amtIns) {
		this.amtIns = amtIns;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

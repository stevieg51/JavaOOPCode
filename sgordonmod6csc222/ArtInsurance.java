package sgordonmod6csc222;

import java.text.NumberFormat;

public class ArtInsurance extends Insurance {

	private String description;
	private double value;

	NumberFormat nf = NumberFormat.getCurrencyInstance();

	public ArtInsurance() {

	}

	public ArtInsurance(Customer cust, String description, double val) {
		super(cust);
		this.description = description;
		value = val;
		calcRate();
	}

	public ArtInsurance(Customer cust, int polNum, double yearlyRate, String descrip, double val) {
		super(cust, polNum, yearlyRate);
		this.description = descrip;
		value = val;
	}

	@Override
	public void calcRate() {
		yearlyRate = 50 * value;

	}

	public String toString() {
		return super.toString() + " for the piece of art work they own. The art is " + this.description
				+ " and has a value of " + nf.format(this.value) + ".";
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}

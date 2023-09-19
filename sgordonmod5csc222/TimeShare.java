package sgordonmod5csc222;

import java.text.NumberFormat;

public class TimeShare {

	private String location;
	private int numBedrooms;
	private double costPerNight;

	public TimeShare() {

	}

	public TimeShare(String loc, int numBed, double costPer) {
		location = loc;
		numBedrooms = numBed;
		costPerNight = costPer;
	}

	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return "A " + numBedrooms + " bedroom glorius room located in " + location + " and rents for "
				+ nf.format(costPerNight) + " per night";
	}

	public void setLocation(String l) {
		location = l;
	}

	public void setNumBedrooms(int num) {
		numBedrooms = num;
	}

	public void setCostPerNight(double cost) {
		costPerNight = cost;
	}

	public String getLocation() {
		return location;
	}

	public int getNumBedrooms() {
		return numBedrooms;
	}

	public double getCostPerNight() {
		return costPerNight;
	}
}

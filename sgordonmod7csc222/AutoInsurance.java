package sgordonmod7csc222;

// "extends" = inherits from
// So-- AutoInsurance gets all of the fields and methods from the Insurance class
// and can add or override any that it wants
public class AutoInsurance extends Insurance {
	
	private int numCars;
	
	public AutoInsurance (Customer cust,int cars)
	{
		super (cust);
		numCars = cars;
		calcRate();
	}	
	
	// empty constructor
	public AutoInsurance ()
	{
	}
	
	// constructor for reading from a file
	public AutoInsurance (Customer cust, int polNum, double yrRate, int numC)
	{
		super(cust,polNum,yrRate);
		numCars = numC;
			
	}
	
	// we were required to write a complete calcRate method by the abstract method in the
	// Insurance class.  Must have the exact same signature
	public  void calcRate()
	{
		yearlyRate = 500*numCars;
	}	
	
	// we override the toString method from the Insurance class
	public String toString ()
	{
		String ans = super.toString();	//  print out the toString method from my super (ie the Insurance class)
		return ans + (" for auto insurance.  The number of cars are " + numCars + ".");  // add on the info for this class
	}
	

	// getters and setters - only for the fields added by this class
	public int getNumCars() {
		return numCars;
	}
	
	public void setNumCars(int numCars) {
		this.numCars = numCars;
	}
	
	
	
}


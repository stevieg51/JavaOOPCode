
package salesAssociation;


public class Sales {
	
	private Customer cust;
	private Inventory inv;
	private int numBought;
	
	public Sales()
	{
	}
	
	public Sales (Customer c, Inventory i, int n)
	{
		cust = c;
		inv = i;
		numBought = n;		
	}
	
	public String toString()
	{
		return cust.toString() + " bought " + numBought + " "+ inv.toStringC(); 
	}

	 
	public Customer getCust() {
		return cust;
	}

	 
	public Inventory getInv() {
		return inv;
	}

	 
	public int getNumBought() {
		return numBought;
	}

	 
	public void setCust(Customer customer) {
		cust = customer;
	}

	 
	public void setInv(Inventory inventory) {
		inv = inventory;
	}

	 
	public void setNumBought(int i) {
		numBought = i;
	}

}

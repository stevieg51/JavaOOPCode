package salesAssociation;

import java.util.*;

public class SalesDriver {

	public static void main(String[] args) {

		ArrayList<Customer> cust = new ArrayList<Customer>();
		ArrayList<Inventory> inv = new ArrayList<Inventory>();
		ArrayList<Sales> sales = new ArrayList<Sales>();

		// load the data
		loadData(cust, inv);

		Scanner scan = new Scanner(System.in);

		boolean more = true;
		while (more) {

			System.out.println("Let's make a sale\n");
			System.out.println("Customers:");
			for (int i=0;i<cust.size();i++)
				System.out.println(i+1 + " " + cust.get(i).toString());
			System.out.println("\nWhich customer number?");
			int numC = scan.nextInt();
			numC = numC-1;
			Customer thisC = cust.get(numC);
			
			System.out.println("\nInventory items:");
			for (int i=0;i<inv.size();i++)
				System.out.println(i+1 + " " + inv.get(i).toString());
			System.out.println("\nWhich inventory number?");
			int numI = scan.nextInt();
			numI = numI-1;
			Inventory thisI = inv.get(numI);
			System.out.println ("\nHow many would you like?");
			int numBought = scan.nextInt();
			if (numBought > inv.get(numI).getNumInStock())
			{
				System.out.println("There are not that many in stock.  Sale cancelled!!");				
			}
			else
			{
				System.out.println("Sold!  The sale has been recorded");
				Sales s = new Sales(thisC,thisI, numBought);
				sales.add(s);
				Inventory inven = inv.get(numI);
				int newNum = inven.getNumInStock()-numBought;
				inven.setNumInStock(newNum);
				
			}
			System.out.println ("\nMore sales? (true/false)");
			more = scan.nextBoolean();
		}
		printSales(sales);

	}

	

	public static void printSales(ArrayList<Sales> s) {
		for (int i=0;i<s.size();i++)
			System.out.println(s.get(i).toString());
	}

	public static void loadData(ArrayList<Customer> c, ArrayList<Inventory> inv) {
		c.add(new Customer("Mouse", "Mickey"));
		c.add(new Customer("Duck", "Donald"));
		inv.add(new Inventory("Widgets", 100, 45.00, 55.00));
		inv.add(new Inventory("Junk", 200, 13.35, 21.00));
	}

}

package sgordonmod6csc222;

import java.util.*;

public class TrackInsurance {
	public static Scanner scan = new Scanner(System.in);

	// method that runs first
	public static void main(String[] args) throws Exception {

		// make an ArrayList of customers and insurance policies
		ArrayList<Customer> cust = new ArrayList<Customer>();
		// note - the ArrayList below can hold Insurance objects
		// but with inheritance, that includes Auto, Health, Life and Art
		ArrayList<Insurance> ins = new ArrayList<Insurance>();

		// create some fake customers (used for testing the program)
		Customer c = new Customer("Duck", "Donald");
		Customer c1 = new Customer("Mouse", "Minnie");
		Customer c2 = new Customer("Mouse", "Mickey");

		// add the customers to the array list

		cust.add(c2);
		cust.add(c1);
		cust.add(c);

		// make and add some insurance policies to the ArrayList
		ins.add(new AutoInsurance(c, 2));
		ins.add(new AutoInsurance(c1, 3));
		ins.add(new HealthInsurance(c, 5));
		ins.add(new HealthInsurance(c2, 1));
		ins.add(new LifeInsurance(c, 30000, 65));
		ins.add(new LifeInsurance(c1, 400000, 34));

		// add your ArtInsurance instances here
		ins.add(new ArtInsurance(c, "Mikey's spaghetti fiasco", 500));
		ins.add(new ArtInsurance(c1, "Crickets Galore", 25));
		ins.add(new ArtInsurance(c2, "A Jug", 485));
		ins.add(new ArtInsurance(c1, "Vinland", 200));
		ins.add(new ArtInsurance(c, "Balboa", 350));

		int choice = 0;
		while (choice >= 0) {
			choice = menu();
			if (choice == 1)
				printAllCustomers(cust);
			else if (choice == 2)
				printAllInsurance(ins);
			else if (choice == 3) {
				System.out.println("Now lets find the information for a certain policy number");
				System.out.println("What policy number do you want to find?");
				int num = scan.nextInt();
				printPolicy(ins, num);
			} else if (choice == 4) {
				System.out.println("Now let's find all of the policies for a given customer");
				System.out.println("What is the customer id?");
				int custNum = scan.nextInt();
				getCustomer(ins, custNum);
			} else if (choice == 5)
				sortCustNum(ins);
			else if (choice == 6)
				sortPolNum(ins);
			else if (choice == 7) {
				System.out.println("Bye!!!!!");
				choice = -1;
			}
		} // end while

	}

	public static int menu() {
		System.out.println("Choice:");
		System.out.println("   1.  Print all customers (call the toString method)");
		System.out.println("   2.  Print all insurance information (call the toString method)");
		System.out.println("   3.  Given a policy number, print the policy information");
		System.out.println("   4.  Find all of the policies for a given customer");
		System.out.println("   5.  Sort the insurance policy information by customer number");
		System.out.println("   6.  Sort the insurance policy information by policy number");
		System.out.println("   7. QUIT!! ");
		System.out.println("\n CHOICE:");
		int value = scan.nextInt();
		return value;

	}

	public static void printAllCustomers(ArrayList<Customer> cust) {
		for (int i = cust.size() - 1; i >= 0; i--) {
			Customer theCust = cust.get(i);
			System.out.println(theCust.toString());
		}

	}

	public static void printAllInsurance(ArrayList<Insurance> insure) {
		// print out all of the information
		for (Insurance ins : insure)
			System.out.println(ins.toString());
	}

	// write a printPolicy method that prints the information for the policy
	// number
	// passed in or the statement "That policy does not exist" if it is not
	// present
	public static void printPolicy(ArrayList<Insurance> insure, int num) {
		boolean foundNum = false;

		for (int i = 0; i < insure.size(); i++) {
			Insurance theInsure = insure.get(i);
			int thePolicyNum = theInsure.getPolicyNumber();
			if (thePolicyNum == num) {
				System.out.println(theInsure.toString());
				foundNum = true;
			}
		}
		if (!foundNum) {
			System.out.println("That policy does not exist.");
			System.out.println();
		}
	}

	// write a getCustomer method that prints the information for all of the
	// policies for a given customer
	// that customer number is passed in. If none, have it print
	// "There are no policies for that customer"
	public static void getCustomer(ArrayList<Insurance> insure, int num) {
		boolean foundCust = false;

		for (int i = 0; i < insure.size(); i++) {
			Customer cust = insure.get(i).getCustomer();
			int theId = cust.getId();
			int policyNum = insure.get(i).policyNumber;
			if (num == theId) {
				printPolicy(insure, policyNum);
				foundCust = true;
			}
		}
		if (!foundCust) {
			System.out.println("There are no policies for that customer");
		}
	}

	// write a method that sorts the policies by policy number
	// look at the example in the search_sort package
	public static void sortPolNum(ArrayList<Insurance> insure) {
		Collections.sort(insure);
		System.out.println("The Customers and policies have been sorted by policy number: ");
		System.out.println();
		for (int i = 0; i < insure.size(); i++) {
			int num = i + 1;
			System.out.println(num + ": " + insure.get(i).toString());
		}
	}

	// write a method that sorts the policies by customer number
	public static void sortCustNum(ArrayList<Insurance> insure) {
		// for(int out=nElems-1; out>1; out--) // outer loop (backward)
		for (int out = insure.size() - 1; out > 1; out--)
			// for(int in=0; in<out; in++) // inner loop (forward)
			for (int in = 0; in < out; in++) {
				Insurance insurance1 = insure.get(in);
				Insurance insurance2 = insure.get(in + 1);
				Customer first = insure.get(in).getCustomer();
				Customer second = insure.get(in + 1).getCustomer();
				int custId1 = first.getId();
				int custId2 = second.getId();
				int pNum1 = insurance1.getPolicyNumber();
				int pNum2 = insurance2.getPolicyNumber();
				if (custId2 < custId1) {
					insure.set(in, insurance2);
					insure.set(in + 1, insurance1);
					// doing a little extra and adding another if statment to sort them by
					// increasing policy number as well
					if (pNum2 < pNum1 && custId1 == custId2) {
						insure.set(in, insurance2);
						insure.set(in + 1, insurance1);
					}
				}

			}
//		for (int i = 0; i < insure.size(); i++) {
//			int num = i + 1;
//			System.out.println(num + ": " + insure.get(i).toString());
//		}
	}



}

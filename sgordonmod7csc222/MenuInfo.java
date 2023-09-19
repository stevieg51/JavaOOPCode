package sgordonmod7csc222;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class MenuInfo {

	public MenuInfo() {
		menu();
	}

	public static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choice:");
		System.out.println("   -1.  Load Pre-existing Data");
		System.out.println("   1.  Print all customers (call the toString method)");
		System.out.println("   2.  Print all insurance information (call the toString method)");
		System.out.println("   3.  Given a policy number, print the policy information");
		System.out.println("   4.  Find all of the policies for a given customer");
		System.out.println("   5.  Sort the insurance policy information by customer number");
		System.out.println("   6.  Sort the insurance policy information by policy number");
		System.out.println("   7.  Store the data in text files ");
		System.out.println("   8. Read the data from the text files ");
		System.out.println("   9. Clear all of the data in memory ");
		System.out.println("   10. Add a customer ");
		System.out.println("   11. Add a policy for a current customer ");
		System.out.println("   999. QUIT!! ");
		System.out.println("\n CHOICE:");
		int value = sc.nextInt();
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

	public static void loadData(ArrayList<Customer> cust, ArrayList<Insurance> ins) {
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
	}

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

	public static void sortPolNum(ArrayList<Insurance> insure) {
		Collections.sort(insure);
		System.out.println("The Customers and policies have been sorted by policy number: ");
		System.out.println();
		for (int i = 0; i < insure.size(); i++) {
			int num = i + 1;
			System.out.println(num + ": " + insure.get(i).toString());
		}
	}

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
	}

	public static void storeInFile(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		System.out.println("Choose/Create a file to store the data. ");
		String filename;
		filename = FileLoc.pickLocOut();

		PrintWriter outputFile = null;
		try {
			outputFile = new PrintWriter(filename);
			// Get data and write it to the file.
			for (int i = 0; i < cust.size(); i++) {
				Customer theCust = ins.get(i).getCustomer();
				outputFile.println(theCust.toStringF());
			}
			for (int i = 0; i < cust.size(); i++) {
				Insurance theIns = ins.get(i);
				outputFile.println(theIns.toStringF());
		}
		}catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			System.out.println("IO Exception.  Need to exit");
			System.exit(0);

		}

	}

	public static void readFromFile(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		Scanner scan = new Scanner(System.in);

		// Get the filename.
		String filename = FileLoc.pickLocRead();

		// Open the file.
		File file = new File(filename);
		Scanner inputFile = null;
		try {
			inputFile = new Scanner(file);

			// Read lines from the file until no more are left.
			while (inputFile.hasNext()) {
				// Read the next name.
				String friendName = inputFile.nextLine();

				// Display the last name read.
				System.out.println(friendName);
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception.  Need to exit");
			System.out.println(ioe.getMessage());
			System.exit(0);

		} finally {
			// Close the file.
			inputFile.close();

		}
	}

	public static void clearData(ArrayList<Insurance> ins, ArrayList<Customer> cust) {

	}

	public static void addCust(ArrayList<Customer> cust) {
		Scanner sc = new Scanner(System.in);

		System.out.println("How many customers would you like to add?");
		int numCusts = sc.nextInt();

		while (numCusts > 0) {
			System.out.println("What is the fisrtname of the customer? ");
			String first = sc.nextLine();

			System.out.println("What is the last name of the customer? ");
			String last = sc.nextLine();
			Customer newCust = new Customer(first, last);

			cust.add(newCust);
			numCusts--;
		}
	}

	public static void addPolicy(ArrayList<Insurance> ins, ArrayList<Customer> cust) {
		Scanner sc = new Scanner(System.in);

		System.out
				.println("Please enter the info needed to create anew policy (Customer Id, Policy #, and Yearly Rate)");

		System.out.println("What is the Customer's ID");
		int custId = sc.nextInt();
		Customer chosenCust;

		for (int i = 0; i < cust.size(); i++) {
			Customer theCust = cust.get(i);
			int id = theCust.getId();
			if (id == custId) {
				chosenCust = theCust;
			}
		}

		int policyNum = sc.nextInt();
		boolean foundNum = false;

		for (int i = 0; i < ins.size(); i++) {
			Insurance theInsure = ins.get(i);
			int thePolicyNum = theInsure.getPolicyNumber();
			if (thePolicyNum == policyNum) {
				policyNum = thePolicyNum;
				foundNum = true;
			}
			if (!foundNum)

			{
				System.out.println("That policy does not exist.");
				System.out.println();

			}
		}

		System.out.println("Enter the Yearly Rate/Expense for policy");
		double yrRate = sc.nextDouble();

//		Insurance newIns = new Insurance(chosenCust, policyNum, yrRate);
//		ins.add(newIns);
	}

}

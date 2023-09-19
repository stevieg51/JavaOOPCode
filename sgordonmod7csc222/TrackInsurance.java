package sgordonmod7csc222;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class TrackInsurance {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		ArrayList<Customer> cust = new ArrayList<Customer>();
		ArrayList<Insurance> ins = new ArrayList<Insurance>();
		
		int choice = -1;
		while (choice > -2) {
			choice = MenuInfo.menu();;
			if (choice == 1)
				MenuInfo.printAllCustomers(cust);
			else if (choice == -1) {
				MenuInfo.loadData(cust, ins);
			} else if (choice == 2)
				MenuInfo.printAllInsurance(ins);
			else if (choice == 3) {
				System.out.println("Now lets find the information for a certain policy number");
				System.out.println("What policy number do you want to find?");
				int num = scan.nextInt();
				MenuInfo.printPolicy(ins, num);
			} else if (choice == 4) {
				System.out.println("Now let's find all of the policies for a given customer");
				System.out.println("What is the customer id?");
				int custNum = scan.nextInt();
				MenuInfo.getCustomer(ins, custNum);
			} else if (choice == 5)
				MenuInfo.sortCustNum(ins);
			else if (choice == 6)
				MenuInfo.sortPolNum(ins);
			else if (choice == 7) {
				MenuInfo.storeInFile(ins, cust);
			} else if (choice == 8) {
				MenuInfo.readFromFile(ins, cust);
			} else if (choice == 9) {
				MenuInfo.clearData(ins, cust);
			} else if (choice == 10) {

			} else if (choice == 999) {
				System.out.println("Bye!!!!!");
				choice = -1;
			}
		} // end while

	}
}

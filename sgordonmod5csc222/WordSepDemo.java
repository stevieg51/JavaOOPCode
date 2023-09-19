package sgordonmod5csc222;

import java.util.Scanner;

public class WordSepDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		WordSeparator ws = new WordSeparator();

		System.out.println("Enter a sentence with no spaces between words");
		System.out.println("and the first letterof each word capitalized");
		System.out.println("Example: DrinkMoreWater");
		
		String userSent = sc.nextLine();
		
		String theOutput = ws.separateSent(userSent);
		System.out.println(theOutput);
	}
	
	public static boolean isValid() { //check to see if sent meets conditions
		return true;
	}

}

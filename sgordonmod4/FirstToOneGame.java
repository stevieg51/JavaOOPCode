package sgordonmod4;

import java.util.Scanner;
//almost done, should check for infinite while loop.
import mod4CSC201ArraysClasses.Dog;

public class FirstToOneGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many faces on the die?: ");
		int numFaces = sc.nextInt();

		System.out.println("How many players?: (2-5)");
		int numPlayers = sc.nextInt();
		int newNum = validateNumPlayers(numPlayers);
		Player[] players = new Player[newNum];

		loadPlayers(players, newNum);
		takeTurn(players, newNum, numFaces);
		determineWinner(players);
	}

	public static void loadPlayers(Player[] players, int num) {
		Scanner sc = new Scanner(System.in);
		int playerNum = 1;
		for (int i = 0; i < num; i++) {
			System.out.println("What is the name of player #" + playerNum);
			String name = sc.nextLine();
			Player newPlayer = new Player(name, 50);
			players[i] = newPlayer;
			playerNum++;
		}

	}

	public static int roll(int numSides) {
		int randNum = (int) (Math.random() * numSides + 1);
		return randNum;
	}

	public static boolean gameInPlay(Player[] player) {
		// Whenever I tell you I spent too long trying to figure out why my code
		// woudln't
		// work just to find out that i had used a greater than sign in this for loop by
		// accident instead of a less than *face palm*.
		// gives a nice tang to programming and made me use that debugger a good bit
		// though haha.
		boolean playing = true;
		for (int i = 0; i < player.length; i++) {
			if (player[i].getPoints() == 1) {
				playing = false;
			}
		}
		return playing;
	}

	public static void takeTurn(Player[] player, int numPlayers, int side) {
		int turnNum = 1;
		boolean playing = gameInPlay(player);
		while (playing) {
			System.out.println();
			System.out.println("Turn #" + turnNum);
			for (int i = 0; i < player.length; i++) {
				int currentPoints = player[i].getPoints();
				int rollPoints = roll(side);
				if (playing) {
					int newPs = currentPoints - rollPoints;
					if (newPs >= 1) {
						System.out.print(player[i].getName() + ": " + currentPoints + " points(s) Roll: " + rollPoints
								+ " SUBTRACTING... ");
						player[i].setPoints(newPs);
						currentPoints = player[i].getPoints();
					} else if (newPs < 1) {
						System.out.print(player[i].getName() + ": " + currentPoints + " points(s) Roll: " + rollPoints
								+ " ADDING... ");
						player[i].setPoints(currentPoints + rollPoints);
						currentPoints = player[i].getPoints();
					}
				}
				System.out.println("New points: " + currentPoints);
			} // end for
			turnNum++;
			playing = gameInPlay(player);
		} // end while

	}

	public static int validateNumPlayers(int num) {
		Scanner sc = new Scanner(System.in);
		boolean yes = true;
		int newNum = 0;
		while (yes) {
			if (num > 1 && num < 6) {
				yes = false;
				newNum = num;
			} else {
				while (newNum < 2 || newNum > 5) {
					System.out.println("Please enter a number 2-5: ");
					newNum = sc.nextInt();
					// need to change boolean to false
				}
				yes = false;
			}
		} // end while
		return newNum;

	}

	public static void determineWinner(Player[] player) {
		for (int i = 0; i < player.length; i++) {
			if (player[i].getPoints() == 1) {
				System.out.println();
				System.out.println("-------");
				System.out.println("The winner is " + player[i].getName() + ".");
			}
		}

	}

}

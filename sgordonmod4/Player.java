package sgordonmod4;

public class Player {

	private String name;
	private int points;

	public Player() {

	}

	public Player(String n, int n1) {
		name = n;
		points = n1;
	}

	public String toString() {
		return "The name of the player is" + name + " and they have " + points;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public void setName(String nm) {
		name = nm;
	}

	public void setPoints(int p) {
		points = p;
	}
}

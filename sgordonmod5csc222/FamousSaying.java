package sgordonmod5csc222;

import java.util.ArrayList;
import java.util.Iterator;

/*Write a class named FamousSaying with a single instance variable named saying that is a String. 
 *  Write the no-argument and full constructor and the getter and setter.   
 *  
 *   Fill in the methods below

*/
public class FamousSaying {

	String saying;

	public FamousSaying() {

	}

	public FamousSaying(String userSaying) {
		this.saying = userSaying;

	}

	public String toString() { // done
		return "The user's saying is " + saying;
	}

	public int numChars() { // done
		return saying.length();
	}

	public String upper() { // done
		return saying.toUpperCase();
	}

	public int numWords() { // should be done
		String[] splitString = saying.split(" ");

		int numWords = 0;
		for (int i = 0; i < splitString.length; i++) {
			numWords = numWords + 1;
		}
		return numWords;

	}

	public int numWords2() {
		return 0;
	}

	public char mostCommonNoTies() {
		int charAppearance = 0;
		int maxCharacter = 0;
		ArrayList<Character> theMostCommon = new ArrayList<>();
		char[] sepCharacters = saying.toCharArray();

		for (int i = 0; i < sepCharacters.length; i++) {

			int theChar = (int) sepCharacters[i];
			charAppearance = 0;

			for (int j = 0; j < sepCharacters.length; j++) {
				int theChar2 = (int) sepCharacters[j];

				if (theChar == theChar2) {
					charAppearance = charAppearance + 1;

					if (charAppearance == maxCharacter && maxCharacter != 0) {
						theMostCommon.add(sepCharacters[i]);
					} else if (charAppearance > maxCharacter) {
						maxCharacter = charAppearance;
						theMostCommon.clear();
						theMostCommon.add(sepCharacters[i]);
					}

				}

			}
		}
		theMostCommon.toArray();
//		return theMostCommon.;
		return ' ';
	}

	public char mostCommon() { // should be done
		int charAppearance = 0;
		int maxCharacter = 0;
		char theMostCommon = ' ';

		char[] sepCharacters = saying.toCharArray();

		for (int i = 0; i < sepCharacters.length; i++) {

			int theChar = (int) sepCharacters[i];
			charAppearance = 0;

			for (int j = 0; j < sepCharacters.length; j++) {
				int theChar2 = (int) sepCharacters[j];

				if (theChar == theChar2) {
					charAppearance = charAppearance + 1;

					if (charAppearance > maxCharacter) {
						maxCharacter = charAppearance;
						theMostCommon = sepCharacters[i];
					}
				}

			}
		}
		return theMostCommon;

	}

	public char mostCommonV2() {
		return ' ';

	}

	public int numVowels() { // should be done

		int numVowels = 0;

		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y', 'Y', 'A', 'E', 'I', 'O', 'U' };

		for (int i = 0; i < saying.length(); i++) {
			char characterToCheck = saying.charAt(i);
			for (int j = 0; j < vowels.length; j++) {
				if ((int) characterToCheck == (int) vowels[j]) {
					numVowels = numVowels + 1;
				}
			}
		}

		return numVowels;
	}

	// f. the number of consonants in the string.
	public int numCons() {

		int numCons = 0;

		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y', 'Y', 'A', 'E', 'I', 'O', 'U' };

		for (int i = 0; i < saying.length(); i++) {
			char characterToCheck = saying.charAt(i);
			for (int j = 0; j < vowels.length; j++) {
				if ((int) characterToCheck == (int) vowels[j]) {

				} else {
					numCons = numCons + 1;
				}
			}
		}

		return numCons;

	}

	public int numTimes(char what) { // should be done
		char[] theSaying = saying.toCharArray();
		int charAppearanceNum = 0;

		for (int i = 0; i < theSaying.length; i++) {
			if ((int) theSaying[i] == (int) what) {
				charAppearanceNum = charAppearanceNum + 1;
			}
		}

		return charAppearanceNum;

	}

	// h. A blank StringBuffer is created and our original string is processed and
	// copied to the
	// StringBuffer
	// all non letters are replaced by an X. The StringBuffer is returned as a
	// String
	public String replaceNonLetters() { //should be done
		StringBuffer buffSaying = new StringBuffer(saying);
		for (int i = 0; i < buffSaying.capacity(); i++) {
			char buffChar = buffSaying.charAt(i);
			if (Character.isDigit(buffChar)) {
				buffSaying.setCharAt(i, 'X');
			}
		}
		String newSaying = buffSaying.toString();
		return newSaying;

	}

	public String getSaying() { // done
		return saying;
	}

	public void setSaying(String saying) { // done
		this.saying = saying;
	}

}

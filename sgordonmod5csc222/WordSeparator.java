package sgordonmod5csc222;

public class WordSeparator {

	private String original;
	private String formatted;

	public WordSeparator() {

	}

	public WordSeparator(String og, String fo) {
		original = og;
		formatted = fo;
	}
	
	public String separateSent(String sentence) { //it inserts a space and always checks the first letter
		setOriginal(sentence);
		StringBuffer buffedSent = new StringBuffer(sentence);
		int lengthOfOriginal = sentence.length();
		for (int i = 0; i < lengthOfOriginal; i++) {
			char buffedChar = buffedSent.charAt(i);
			boolean isTrue = Character.isUpperCase(buffedChar);
			boolean notIllegalChar = charCompare(buffedSent);
			if (isTrue && notIllegalChar && buffedChar != sentence.charAt(0)) {
				buffedSent.insert(i, ' ');
				i = i + 1;
				lengthOfOriginal = lengthOfOriginal + 1;
			}
		}
		String separated = buffedSent.toString();
		setFormatted(separated);
		return separated;
	}
	
	public boolean charCompare(StringBuffer buffedSent) {
		char[] illegalChars = {'.', '!', '?', '%', '$', 'I'};
		boolean changeChar = true;
		for (int i= 0; i < illegalChars.length; i++) {
			char buffedChar = buffedSent.charAt(i);
			if(buffedChar == illegalChars[i]) {
				changeChar = false;
			}
		}
		return changeChar;
		
	}
	
	

	public String toString() {
		return "wassuuuppp";
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String og) {
		original = og;
	}

	public String getFormatted() {
		return formatted;
	}

	public void setFormatted(String fo) {
		formatted = fo;
	}
}

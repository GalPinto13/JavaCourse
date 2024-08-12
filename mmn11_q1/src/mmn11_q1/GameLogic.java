package mmn11_q1;

public class GameLogic extends WordCollection {
	
	// final variables
	static final char u = '_';
	static final char space = ' ';
	static final String letters = "abcdefghijklmnopqrstuvwxyz";
	
	//attributes
	private String wrd;
	private int numGusses;
	private int successGusses;
	private String unGesLet;
	private String displayWrd;
	
	//constructor
	public GameLogic() {
		wrd = getRandomWord();
		numGusses = 0;
		successGusses = 0;
		unGesLet = "abcdefghijklmnopqrstuvwxyz".substring(0);
		displayWrd = "";
		for (int i = 0; i < wrd.length(); ++i) {
			displayWrd = displayWrd + '_' + ' ';
		}
	}
	
	//methods
	
	/* checks if the input is valid */
	public boolean validGuess(String inStr) {
		char a = Character.toLowerCase(inStr.charAt(0));
		int i = unGesLet.indexOf(a);
		if (!Character.isLetter(a)) { // not a char
			System.out.println("The inserted value isn't a valid letter, please try again");
			return false;
		} else if (inStr.length() > 1) { // not a single char
			System.out.println("Please insert only 1 character at a time");
			return false;
		} else if (i < 0) { // char has being chosen already
			System.out.println("The Inserted letter has already been choosen, please try again");
			return false;
		} else {
			unGesLet = unGesLet.substring(0, i) + unGesLet.substring(i + 1); // updating available char list
			return true;
		}
	}

	/* applying the guess */
	public void applyGuess(char a) {
		int i = 0;
		boolean sucFlag = false; // true = succeeded guess

		while (i >= 0) {
			i = wrd.indexOf(Character.toLowerCase(a), i);
			if (i >= 0) { // char exists in the word
				displayWrd = displayWrd.substring(0, 2 * i) + a + displayWrd.substring(2 * i + 1);
				++successGusses;
				sucFlag = true;
				++i;
			}
		}

		++numGusses;
		printCurrentState(sucFlag, a);
	}
	/* printing the current guess results */
	private void printCurrentState(boolean sucFlag, char a) {
		if (sucFlag) {
			System.out.println("Nice One! the Character Guess '" + a + "' exists in the word");
		} else {
			System.out.println("Too Bad! the Character Guess '" + a + "' Doesn't exist in the word");
		}

		System.out.println("Current Guessed word:");
		System.out.println(displayWrd);
	}
	
	
	/* check if the whole word is guessed */
	public boolean success() {
		return successGusses == wrd.length();
	}
	
	/* method for getting specific attributes */
	public int getnumGusses() {
		return numGusses;
	}

	public String getunGesLet() {
		return unGesLet;
	}

	/*instead of creating new instance, re-initializing the attributes */
	public void restart() {
		wrd = getRandomWord();
		numGusses = 0;
		successGusses = 0;
		unGesLet = "abcdefghijklmnopqrstuvwxyz".substring(0);
		displayWrd = "";
		for (int i = 0; i < wrd.length(); ++i) {
			displayWrd = displayWrd + '_' + ' ';
		}

	}
}
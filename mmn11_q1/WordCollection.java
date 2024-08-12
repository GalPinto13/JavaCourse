package mmn11_q1;

import java.util.Random;
/* storing the words collection and allowing to pick a random word from it */
public class WordCollection {
	/* The static words collection */
	static final String[] wordsArray = {"governor", "exceed", "friendship", "creature", "recent", "flavor",
			"lie", "consultant", "then", "for", "benefit", "childhood", "gold", "supporter", "wrap", "upper", "plane",
			"improvement", "several", "defend", "peer", "prime", "thanks", "horizon", "index", "eastern", "ceremony",
			"whatever", "procedure", "commit", "something", "credit", "occasionally", "species", "window", "continue",
			"dependent", "heavy", "resistance", "chapter", "lunch", "risk", "charge", "shell", "attorney", "party",
			"owner", "row", "tent", "okay"};

	/* pick random word method */
	public static String getRandomWord() {
		Random rnd = new Random();
		int i = rnd.nextInt(50);
		return wordsArray[i];
	}
}
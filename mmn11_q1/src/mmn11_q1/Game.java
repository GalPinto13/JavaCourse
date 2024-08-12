package mmn11_q1;

import java.util.Scanner;

/* the main class of the Game */
public class Game {
	public static void main(String[] args) {
		boolean play = true;
		GameLogic gl = new GameLogic();
		Scanner scanner = new Scanner(System.in);
		String inStr;

		while (true) {
			/* main loop for each game */
			while (play) { 
				System.out.println("Welcome to the Game of Guessing, a random word has been choosen for you to Guess");
				/* secondary loop for each guess*/
				while (!gl.success()) { // as long as not whole word is guessed
					System.out.println("Please pick a letter from the below unguessed letters and press enter: ");
					System.out.println(gl.getunGesLet());// print available char list
					inStr = scanner.next(); // receive input
					if (gl.validGuess(inStr)) // if input is valid apply the guess
						gl.applyGuess(Character.toLowerCase(inStr.charAt(0)));
				}

				System.out.println("Congrats! You've guessed the word in " + gl.getnumGusses() + " Guesses");
				System.out.println("If you wish to play again please press y/n");
				inStr = scanner.next();
				if (!inStr.equals("Y") && !inStr.equals("y")) 
					play = false;
				else 
					gl.restart(); // if the user wants to play again restart the gl obj
				
			}

			scanner.close();
			return;
		}
	}
}
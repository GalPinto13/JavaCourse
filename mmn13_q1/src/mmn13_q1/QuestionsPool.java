package mmn13_q1;

import java.util.ArrayList;

/*Class for holding all questions in the same pool*/
public class QuestionsPool {
	// questions and answers
	private final static int QUESTIONS_NUM = 10;
	private static String[] questions = { "What is the capital of France?", "Which planet is known as the Red Planet?",
			"What is the largest mammal in the world?", "In what year did Christopher Columbus reach the Americas?",
			"Which element has the chemical symbol 'O'?", "What is the largest ocean on Earth?",
			"Who wrote 'Romeo and Juliet'?", "What is the powerhouse of the cell?",
			"Which gas do plants absorb from the atmosphere during photosynthesis?", "What is the currency of Japan?" };
	private static String[][] answers = { { "Paris", "Berlin", "Rome", "Madrid" },
			{ "Mars", "Venus", "Jupiter", "Saturn" }, { "Blue Whale", "Elephant", "Giraffe", "Cheetah" },
			{ "1492", "1607", "1776", "1812" }, { "Oxygen", "Gold", "Iron", "Silver" },
			{ "Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean" },
			{ "William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain" },
			{ "Mitochondria", "Nucleus", "Endoplasmic Reticulum", "Cell Membrane" },
			{ "Carbon Dioxide", "Oxygen", "Nitrogen", "Hydrogen" }, { "Yen", "Won", "Ringgit", "Yuan" } };
	private static String[] correctAnswers = { "Paris", "Mars", "Blue Whale", "1492", "Oxygen", "Pacific Ocean",
			"William Shakespeare", "Mitochondria", "Carbon Dioxide", "Yen" };

	// attributes
	ArrayList<Question> pool;

	// constructor
	public QuestionsPool() {
		this.pool = new ArrayList<Question>();
		for (int i = 0; i < QUESTIONS_NUM; i++) {
			this.pool.add(new Question(questions[i], answers[i], correctAnswers[i]));
		}
	}

	// getter
	public ArrayList<Question> getPool() {
		return this.pool;
	}

}

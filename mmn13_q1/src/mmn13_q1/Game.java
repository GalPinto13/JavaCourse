package mmn13_q1;

import java.util.ArrayList;

/*Class for holding all needed details to the Game \ Quiz operation*/
public class Game {
	// attributes
	private int correctCount;
	private QuestionsPool qPool;
	private int currentQuestionNumber;

	// constructor
	public Game() {
		this.correctCount = 0;
		this.qPool = new QuestionsPool();
		this.currentQuestionNumber = 0;

	}

	// getters
	public QuestionsPool getQPool() {
		return this.qPool;
	}

	public int getCorrectCount() {
		return this.correctCount;
	}

	public int getCurrentQuestionNumber() {
		return this.currentQuestionNumber;
	}

	public String getCurrentQuestionText() {
		return qPool.getPool().get(currentQuestionNumber).getQuestion();
	}

	public ArrayList<String> getCurrentAnswers() {
		return qPool.getPool().get(currentQuestionNumber).getAnswers();
	}

	public int getNumOfQuestions() {
		return this.qPool.getPool().size();
	}

	public boolean isFinalQuestion() {
		return this.currentQuestionNumber + 1 == this.qPool.getPool().size();
	}

	// setters
	public void setCorrectCount(int count) {
		this.correctCount = count;
	}

	public void setCurrentQuestionNumber(int current) {
		currentQuestionNumber = current;
	}

	// restarting the Game instance in case the user wants to play again
	public void restart() {
		this.currentQuestionNumber = 0;
		this.correctCount = 0;
	}

	// check if the answer selected by the user is correct
	public boolean correctAnswer(String answer) {
		String correctAnswer = qPool.getPool().get(currentQuestionNumber).getCorrectAnswer();
		return correctAnswer.compareTo(answer) == 0;
	}
}

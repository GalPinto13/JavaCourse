package mmn13_q1;

import java.util.ArrayList;
import java.util.Collections;
/*Class for holding the Question object*/
public class Question {
	// attributes 
	private String question;
	private ArrayList<String> answers;
	private String correctAnswer;
	
	// constructor
	public Question (String question, String[] answers, String correctAnswer) {
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.answers = new ArrayList<String> ();
		for(String answer : answers) {
			this.answers.add(answer);
			
		}
		this.correctAnswer = correctAnswer;
	}
	
	//getters
	public String getQuestion() {
		return this.question;
	}
	
	//return the answers in shuffled order
	public ArrayList<String> getAnswers() {
		Collections.shuffle(this.answers); 
		return this.answers;
	}
	
	public String getCorrectAnswer() {
		return this.correctAnswer;
	}
	
}

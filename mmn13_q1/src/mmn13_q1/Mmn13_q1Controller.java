package mmn13_q1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;

/*Controller class to interact with the Screen objects*/
public class Mmn13_q1Controller {
	
	// init a Game object
	Game game = new Game();
	
	
	@FXML
	// setting the first question
	public void initialize() {
		setQuestion();
		setAnswers();
		button.setText("Next Question");
	}

	
    @FXML
    private Text questionNumber;
    

    @FXML
    private RadioButton answer1;

    @FXML
    private ToggleGroup answers;

    @FXML
    private RadioButton answer2;

    @FXML
    private RadioButton answer3;

    @FXML
    private RadioButton answer4;

    @FXML
    private Button button;

    @FXML
    void buttonPressed(ActionEvent event) {
    	 // getting the selected answer
    	 RadioButton selectedAnswer = (RadioButton) answers.getSelectedToggle();
    	 answers.selectToggle(null); // clear selections
    	 if (selectedAnswer == null) { // if the user didn't chose any answer
        	 	showPopup("Answer must be selected!");
         }
         else {
        	 	if (game.correctAnswer(selectedAnswer.getText())) {
        	 	// the answer is correct
        	 		game.setCorrectCount(game.getCorrectCount() + 1);
        	 		showPopup("Answer is Correct!");
        	 		
        	 	}
        	 	else {
        	 		showPopup("Answer is not Correct!");
        	 	}
		        if (button.getText().compareTo("Submit Quiz") == 0) { // reached to the end of the quiz 
		        	handleEndQuiz();
		         }
		        else {
		        	resumeQuiz();	 
		         }
         }
    }
    
    // handling the continues operation of the Quiz
    private void resumeQuiz() {
    	game.setCurrentQuestionNumber(game.getCurrentQuestionNumber() + 1);
	   	if (game.isFinalQuestion()) // the final question is about to come
	   		 button.setText("Submit Quiz");
    	 setQuestion();
    	 setAnswers();
    }
    
    // handling the End of the quiz
    private void handleEndQuiz() {
    	showPopup("Game Over!\n Your Grade is: " 
   			 + (((double) game.getCorrectCount() / (double) game.getNumOfQuestions()) * 100) );
   	 	showConfirmationDialog();// asking the user if they wants to play again
    }
    
    // checking if an answer has been chosen and if it's correct
    
    
    // set the question at the top of the screen
    private void setQuestion() {
    	questionNumber.setText(game.getCurrentQuestionText());
    }
    
    // set the possible answers on the screen
    private void setAnswers() {
    	ArrayList<String> answers = game.getCurrentAnswers(); // the answer returned in shuffled order from that function
    	answer1.setText(answers.get(0));
    	answer2.setText(answers.get(1));
    	answer3.setText(answers.get(2));
    	answer4.setText(answers.get(3));
    	
    }
    
    // pop up message window for displaying the user system messages
    private void showPopup(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        // Show the alert and wait for the user's response
        alert.showAndWait();
    }
    
    // confirmation dialog pop up window for the user to decide if doing another quiz
    private void showConfirmationDialog() {
    	// creating confirmation dialog
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Do you want to take the Quiz Again?");  
        // Add "Yes" and "No" buttons to the dialog
        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        // checks if the user click Yes or No
        alert.showAndWait().ifPresent(response -> {
            if (response == buttonTypeYes) {
                // User clicked "Yes"
                game.restart();
                initialize();
            } else if (response == buttonTypeNo) {
            	// user clicked "No" so closing the Quiz window
            	Platform.exit();
            }
        });
    }

}
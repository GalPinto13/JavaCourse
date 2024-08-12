package mmn13_q2;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

// controller class for implementing the calculator logic into the created screen in scene builder
public class Mmn13_q2Controller {
	// two arrayList for holding the arguments and operation that needs to be
	// perform on them
	private ArrayList<Character> operationsSeries = new ArrayList<Character>();
	private ArrayList<Double> argumentSeries = new ArrayList<Double>();

	@FXML
	private Button dotPressed;

	@FXML
	// holding the text for arguments to be selected or results of a calculation
	private TextField results;

	@FXML
	// when hitting the Clear button we creating a new arrayLists and clean the
	// result text field
	void clearPressed(ActionEvent event) {
		operationsSeries = new ArrayList<Character>();
		argumentSeries = new ArrayList<Double>();
		results.setText("");
	}

	@FXML
	// function that handles hitting '/'
	void dividePressed(ActionEvent event) {
		if(isOperationValid()) 
				operationsSeries.add('/');			
		
	}

	@FXML
	// function that handles hitting '.'
	void dotPressed(ActionEvent event) {
		if(isOperationValid()) 
			results.setText(results.getText() + ".");	
	}

	@FXML
	// function that handles hitting '-'
	void minusPressed(ActionEvent event) {
		if(isOperationValid()) 
				operationsSeries.add('-');			
	}

	@FXML
	// function that handles hitting '*'
	void multiplayPressed(ActionEvent event) {
		if(isOperationValid())
				operationsSeries.add('*');

	}

	@FXML
	// function that handles hitting '+'
	void plusPressed(ActionEvent event) {
		if(isOperationValid())  
				operationsSeries.add('+');
				
			

		}

	

	@FXML
	// function that handles hitting = hence calculating the results
	void resultPressed(ActionEvent event) {
		double calculationResults;
		if(isOperationValid()) {
				calculationResults = calculateExpression(operationsSeries, argumentSeries);
				if (isWholeNumber(calculationResults))
					results.setText((int) calculationResults + ""); // the results is whole number hence we remove the .0													// .0
				else
					results.setText((double) calculationResults + "");
			}		
	}
	

	@FXML
	// function that handles hitting '+/-'
	void signPressed(ActionEvent event) {
		String tempresults = results.getText(); // saving the result since isOperationValid delete them is the result is valid number
		if(isOperationValid())  {
			argumentSeries.remove(argumentSeries.size() - 1); // removing the argument that was inserted due to isOpreationValid()
			// as we want to add an argument only when one of the operation selected ('/', '*','-','+','=')
			results.setText(tempresults); // re-adding the results
			if (results.getText().charAt(0) == '-')
				results.setText(results.getText().substring(1)); // negative number become positive
			else
				results.setText("-" + results.getText()); // positive number become negative
			
		}
	}

	// method for hitting each on of the digits buttons and append it to the result
	// text field
	@FXML
	void eightPressed(ActionEvent event) {
		results.setText(results.getText() + "8");

	}

	@FXML
	void fivePressed(ActionEvent event) {
		results.setText(results.getText() + "5");

	}

	@FXML
	void fourPressed(ActionEvent event) {
		results.setText(results.getText() + "4");

	}

	@FXML
	void ninePressed(ActionEvent event) {
		results.setText(results.getText() + "9");

	}

	@FXML
	void onePressed(ActionEvent event) {
		results.setText(results.getText() + "1");

	}

	@FXML
	void sevenPressed(ActionEvent event) {
		results.setText(results.getText() + "7");

	}

	@FXML
	void sixPressed(ActionEvent event) {
		results.setText(results.getText() + "6");

	}

	@FXML
	void threePressed(ActionEvent event) {
		results.setText(results.getText() + "3");

	}

	@FXML
	void twoPressed(ActionEvent event) {
		results.setText(results.getText() + "2");

	}

	@FXML
	void zeroPressed(ActionEvent event) {
		if (results.getText().compareTo("") == 0 && operationsSeries.size() > 0
				&& operationsSeries.get(operationsSeries.size() - 1) == '/') // attempting to divide by 0
			showPopup("Divding by Zero is not allowed");
		else
			results.setText(results.getText() + "0");

	}

	// method the calculate the results based on the arguments and operations lists
	private double calculateExpression(ArrayList<Character> operations, ArrayList<Double> arguments) {
		double result = arguments.get(0);
		arguments.remove(0);
		char operation;
		while (arguments.size() > 0) { // still arguments left so more operation left as well
			operation = operations.get(0);
			operations.remove(0);
			if (operation == '/')
				result /= arguments.get(0);
			else if (operation == '*')
				result *= arguments.get(0);
			else if (operation == '-')
				result -= arguments.get(0);
			else if (operation == '+')
				result += arguments.get(0);
			arguments.remove(0);
		}
		// finish calculations so both lists are empty
		return result;
	}

	// pop up message window for displaying to the user system messages
	private void showPopup(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText(message);
		// Show the alert and wait for the user's response
		alert.showAndWait();
	}

	private static boolean isWholeNumber(double value) {
		// Check if the difference between the double value and its truncated version is
		// negligible
		return Math.abs(value - Math.floor(value)) < 1e-10;
	}
	// method for checking if the if value in the results text field is valid and append it to the argumentList
	private boolean isOperationValid() {
		if (results.getText().compareTo("") == 0) { // empty value
			showPopup("Before Operation a numeric sign should be exist please choose a number");
			return false;
		}
			
		else if (results.getText().charAt(results.getLength() - 1) == '.') { // value that ends with dot
			showPopup("Invalid Argument!");
			return false;
		}
		else {
			try {
				argumentSeries.add(Double.parseDouble(results.getText())); 
				results.setText("");
				return true;
			} catch (NumberFormatException e) { // not a valid number
				showPopup("Invalid Argument!"); 
				return false;
			}
			
		}
			
	}

}

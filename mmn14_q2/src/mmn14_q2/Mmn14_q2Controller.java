package mmn14_q2;


import java.util.Map;
import java.util.Optional;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.StageStyle;

public class Mmn14_q2Controller {
	// for the Input Dialog vbox creation
	private final static int DEFAULT_SPACING = 10;
	private final static int DEFAULT_PADDING = 10;

	private PhoneBook phoneBook;// A PhoneBook instance for the application

	@FXML
	private TextField searchBar;

	@FXML
	private TableView<Map.Entry<String, String>> contactTable;

	@FXML
	private TableColumn<Map.Entry<String, String>, String> name;

	@FXML
	private TableColumn<Map.Entry<String, String>, String> phone;
	ObservableList<Map.Entry<String, String>> entryList;

	@FXML
	public void initialize() {
		phoneBook = new PhoneBook();
		entryList = FXCollections.observableArrayList(phoneBook.getPhoneBook().entrySet()); // init for the ObservableList
		name.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKey()));// setting the needed
																								// ObservableValue
		phone.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getValue())); // setting the needed
																									// ObservableValue
		contactTable.setItems(entryList);// binding the ObservableList entryList to the table in the application
											// (contact table)
	}

	@FXML
	void addContactPressed(ActionEvent event) {
		// init for the Add input dialog
		String[] fields = { "Name", "Phone Number (10 continous digits)" };
		String[] results = showInputDialog(fields, "New Contact", "Please enter a new Contact Details");
		try {
			phoneBook.addContact(results[0], results[1]);
			populatePhoneBook();
		} catch (IlleagalNameException e) {
			showPopup("Invalid Name!");

		} catch (IlleagalPhoneException e) {
			showPopup("Invalid Phone Number!");

		} catch (IllegalContactException e) {
			showPopup("Contact Already Exist!");

		}
	}

	@FXML
	// method that ingest to the ObservableList the recent TreeMap's set of the phoneBook instance
	// (getPhoneBook returns TreeMap <String, String> object)
	private void populatePhoneBook() {
		entryList.setAll(phoneBook.getPhoneBook().entrySet());
	}

	@FXML
	void clearSearchPressed(ActionEvent event) {
		searchBar.setText("");
		
		contactTable.setItems(entryList);// restore the whole entries exist in phoneBook instance to the TableView contactTable
	}

	@FXML
	void deleteContactPressed(ActionEvent event) {
		// init for the Delete input dialog
		String[] fields = { "Name" };
		String[] results = showInputDialog(fields, "Delete Contact", "Please insert the Contact Name to delete");
		try {
			phoneBook.removeContact(results[0]);
			populatePhoneBook();
		} catch (IllegalContactException e) {
			showPopup("Contact doesn't Exist!");
		}
	}

	@FXML
	void searchPressed(ActionEvent event) {
		// temp ObservableList, won't be empty only if
		// phoneBook.getEntriesBykey(searchBar.getText()) will return non empty Set
		ObservableList<Map.Entry<String, String>> temp = FXCollections
				.observableArrayList(phoneBook.getEntriesBykey(searchBar.getText()));
		contactTable.setItems(temp); // binding the table to the temp ObservableList
	}

	@FXML
	void updateContactPressed(ActionEvent event) {
		// init for the Update input dialog
		String[] fields = { "Name", "Updated Phone Number (10 continous digits)" };
		String[] results = showInputDialog(fields, "Update Contact", "Enter the Contact name and their new phone");
		try {
			phoneBook.updateContactPhone(results[0], results[1]);
			populatePhoneBook();
		} catch (IlleagalPhoneException e) {
			showPopup("Invalid Phone Number!");

		} catch (IllegalContactException e) {
			showPopup("Contact Doesn't Exist!");
		}
	}

	// method for showing input dialog to the user and return their input as an array of Strings
	private String[] showInputDialog(String[] fields, String title, String headerTitle) {
		String[] results = new String[fields.length];// the return input

		// Create a VBox to hold TextFields
		VBox vbox = new VBox();
		vbox.setSpacing(DEFAULT_SPACING);
		vbox.setPadding(new Insets(DEFAULT_PADDING));
		// Dynamically add TextFields to the vbox based on the fields
		for (String field : fields) {
			TextField textField = new TextField();
			textField.setPromptText(field + ": ");
			vbox.getChildren().add(textField);
		}
		// Create an Alert
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerTitle);

		// Set the VBox as the content of the Alert
		alert.getDialogPane().setContent(vbox);

		// Show the Alert and wait for the user's response
		Optional<ButtonType> result = alert.showAndWait();

		// Process the result if the user clicks "OK"
		result.ifPresent(buttonType -> {
			if (buttonType == ButtonType.OK) {
				for (int i = 0; i < fields.length; i++)
					results[i] = ((TextField) vbox.getChildren().get(i)).getText();
			}
		});
		return results;
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
	
	
	

}

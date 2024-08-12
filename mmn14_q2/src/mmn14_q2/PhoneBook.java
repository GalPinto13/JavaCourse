package mmn14_q2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
	// default contacts
	final static String [][] DEFAULT_CONTACTS = {{"John Doe", "1234567890"}, {"Jane Smith", "9876543210"}, {"Mike Johnson", "5678901234"},
			 {"Emily Davis", "2345678901"}, {"Chris Miller", "8901234567"}, {"Amanda White", "3456789012"},
			 {"Brian Brown", "6789012345"}, {"Laura Taylor", "0123456789"}, {"Kevin Wilson", "5432109876"},
			 {"Olivia Martinez", "7890123456"}, {"Daniel Lee", "4567890123"}, {"Sarah Jones", "2109876543"},
			 {"Alex Thompson", "8765432109"}, {"Megan Garcia", "1098765432"}, {"Ryan Miller", "3210987654"}};
	// attribute
	private TreeMap<String, String> phoneBook;

	// constructor
	public PhoneBook() {
		phoneBook = new TreeMap<String, String>();
		//adding the defult contacts to the PhoneBook
		for (String[] contact : DEFAULT_CONTACTS)
			phoneBook.put(contact[0], contact[1]);

	}

	// method for adding contact - throwing exceptions if the given details are
	// illegal
	public void addContact(String name, String phone)
			throws IlleagalNameException, IlleagalPhoneException, IllegalContactException {
		if (!isValidName(name))
			throw new IlleagalNameException();
		if (!isValidPhone(phone))
			throw new IlleagalPhoneException();
		if (phoneBook != null && phoneBook.containsKey(name))
			throw new IllegalContactException();
		phoneBook.put(name, phone);
	}

	private boolean isValidName(String name) {
		return name.matches("^^[A-Za-z]+(?: [A-Za-z]+)?$"); // Ensure name have only alphabet characters, at least 1
															// word, and if consists from two words only single space
															// is allowed between them. Maximum 2 words
	}

	private boolean isValidPhone(String phone) {
		return phone.matches("^[0-9]+$") && phone.length() == 10; // Ensure name have only digits characters and it's 10
																	// digits long
	}

	// method for removing a contact - throwing exceptions if the given details are
	// illegal
	public void removeContact(String name) throws IllegalContactException {
		if (phoneBook != null && !phoneBook.containsKey(name))
			throw new IllegalContactException();
		else
			phoneBook.remove(name);
	}

	// method for update a contact - throwing exceptions if the given details are
	// illegal
	public void updateContactPhone(String name, String phone) throws IllegalContactException, IlleagalPhoneException {
		if (phoneBook != null && !phoneBook.containsKey(name))
			throw new IllegalContactException();
		else {
			if (!isValidPhone(phone))
				throw new IlleagalPhoneException();
			phoneBook.put(name, phone);
		}
	}

	// getter
	public TreeMap<String, String> getPhoneBook() {
		return this.phoneBook;
	}

	// method to return filtered set to be used in the controller by an
	// ObservableList object when the user wants to search for a contact
	public Set<Map.Entry<String, String>> getEntriesBykey(String key) {
		Set<Map.Entry<String, String>> resultEntries = new HashSet<>(); // creating a set to pass later to the
																		// ObservableList
		for (Map.Entry<String, String> entry : phoneBook.entrySet()) { // traversing over the phoneBook entries
			if (entry.getKey().contains(key)) {// the entry key contains the parameter key 
				resultEntries.add(entry); // add the entry to the set
			}
		}
		return resultEntries; // return the set
	}

}

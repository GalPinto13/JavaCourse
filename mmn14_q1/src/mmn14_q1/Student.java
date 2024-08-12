package mmn14_q1;

public class Student implements Comparable<Student> {

	// attributes
	private String firstName;
	private String lastName;
	private int id;
	private int yearOfBirth;

	// constructor
	public Student(String firstName, String lastName, int id, int yearOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.yearOfBirth = yearOfBirth;

	}

	// getters
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getId() {
		return this.id;
	}

	public int getYearOfBirth() {
		return this.yearOfBirth;
	}

	// implement compateTo based on the students ids
	public int compareTo(Student s) {
		if (this.id > s.getId())
			return 1;
		else if (this.id < s.getId())
			return -1;
		else
			return 0;
	}
	// returning a String representation of the instance attributes
	public String toString() {
		return "Student ID: " + this.id + ", Student Name: " + this.firstName + " " + this.lastName
				+ ", Student Year of Birth: " + this.yearOfBirth;

	}

}

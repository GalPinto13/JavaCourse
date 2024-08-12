package mmn14_q1;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// creating 4 students for the testing
		Student s1 = new Student("Dani", "Greenberg", 7458, 1995);
		Student s2 = new Student("Ruth", "Elbaz", 1854, 1990);
		Student s3 = new Student("Ofer", "Talker", 9865, 2000);
		Student s4 = new Student("Yoni", "Bismuth", 5869, 1991);
		
		Student[] students = { s1, s2, s3 };
		Integer[] avgGrade = { new Integer(78), new Integer(95), new Integer(87) };// avg grades for the first 3 students
		AssociationTable<Student, Integer> studentsTable = createTable(students, avgGrade);// creating the table
		
		studentsTable.add(s4, 80); // Adding s4 to the table
		studentsTable.add(s3, 95); // update s3 grade from 87 to 95
		studentsTable.remove(s2); // remove s2 from the table
		
		// creating an iterator for traversing the students table keys
		Iterator<Student> keyIterator = studentsTable.keyIterator();
		// printing the table content
		System.out.println("Accosication Table Content:\n-----------------------------");
		while (keyIterator.hasNext()) {
			Student s = keyIterator.next();// fetching the key from the iterator
			System.out.println(s.toString() + "| Average Grade: " + studentsTable.getValue(s)); 
		}

	}
	// private method to handle the creation of the table with try catch
	private static AssociationTable<Student, Integer> createTable(Student[] students, Integer[] avgGrade) {
		try {
			AssociationTable<Student, Integer> tempTable = new AssociationTable<Student, Integer>(students, avgGrade);
			return tempTable;
		} catch (IllegalArgumentException e) {
			System.out.println("The Students and the average grades are not from the same size");
			return null;
		}

	}

}

package mmn14_q1;

import java.util.Iterator;
import java.util.TreeMap;

public class AssociationTable<E extends Comparable<E>, T> {
	// attributes
	private TreeMap<E, T> table;
	
	// constructor
	public AssociationTable() {
		this.table = new TreeMap<E, T>();
	}

	public AssociationTable(E[] keys, T[] values) throws IllegalArgumentException {
		if (keys.length != values.length)
			throw new IllegalArgumentException(); // keys and value number is not equal
		this.table = new TreeMap<E, T>();
		for (int i = 0; i < keys.length; i++)
			table.put(keys[i], values[i]); // put method is adding keys in ascending order based on their compareTo function, therefore the table returns in the needed order

	}
	// adding keys in their correct place, assuming keys and values aren't null 
	public void add(E key, T value) {
		this.table.put(key, value);
	}
	// getting value if Key exist in the table
	public T getValue(E key) {
		if (this.table.containsKey(key))
			return this.table.get(key);
		else
			return null;
	}
	// checks if the key inside the table
	public boolean contains(E key) {
		return this.table.containsKey(key);
	}
	// removing a key from the table if it exist
	public boolean remove(E key) {
		if (contains(key)) {
			this.table.remove(key);
			return true;
		} else
			return false;
	}
	// returning the size of the table
	public int size() {
		return this.table.size();
	}
	// creating an iteration for traversing the table keys
	public Iterator<E> keyIterator() {
		Iterator <E> iterator = this.table.keySet().iterator(); // the keySet() method returns a 'set' view of the elements in the table in their standard order so the keys will be received by the sorting order as requested
		return iterator;
	}

}

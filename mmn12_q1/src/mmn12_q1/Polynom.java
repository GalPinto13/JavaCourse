package mmn12_q1;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*class for creating the polynom and perform actions on it*/
public class Polynom {
	//attribute
	private ArrayList<Monom> poly;
	
	//constructor
	public Polynom(int pow[], double coe[]) {
		try {
			// verifying the arrays are from the same size
			if(pow.length != coe.length)
				throw new Exception("The Powers Array and the Coefficients Array should have the same length");
			// adding Monoms object to the Polynom's array
			poly = new ArrayList<>();
			for(int i = 0; i < pow.length; i++) {
				if(coe[i] != 0) // monoms with coeffieicent 0 not relevant
					poly.add(new Monom(pow[i], coe[i]));
			}
			
			//sorting the arrayList based on the power values
			// Custom comparator to sort based on the pow values of the Monom object
	        Comparator<Monom> customComparator = Comparator.comparingInt(Monom::getPow);

	        // Use Collections.sort() with the custom comparator
	        Collections.sort(poly, Collections.reverseOrder(customComparator));
		}
		catch (Exception e) {
			System.err.println("Exception Cought: " + e.getMessage());
		}
		
	}
	//getter
	public ArrayList<Monom> getPoly(){
		return this.poly;
	}
	//setter
	public void getPoly(ArrayList<Monom> p){
		this.poly = p;
	}
	// return a new Polynom of adding the Polynom p to the Polynom that called this method
	public Polynom plus(Polynom p) {
		return this.plusOrMinus(p);// this private method is actually doing the sum
	}
	
	// return a new Polynom of substructing the Polynom p from the Polynom that called this method 
	public Polynom minus(Polynom p) {
		
		p.switchSign();// change p to -p
		Polynom result =  this.plusOrMinus(p);  
		p.switchSign();// change p to -p (revert)
		return result;
	}
	
	// converting Polynom p to -p
	private void switchSign () {
		for (int i = 0; i < this.poly.size(); i++) {
			this.poly.get(i).setCoe(this.poly.get(i).getCoe() * -1);
		}
	}
	
	// Return a new polynom that is the sum of the called Polynom and another Polynum p
	private Polynom plusOrMinus(Polynom p) {
		// creating the new polynom's coefficient and power arrays
		int thiSize = this.poly.size();
		int pSize = p.poly.size();
		int[] pow = new int[thiSize + pSize];
		double[] coe = new double[thiSize + pSize];
		
		// i index of the calling object, j index for the parameter object, k for the new polynom
		int i = 0, j = 0, k = 0;
		
		while ( i < thiSize && j < pSize) {// run through all of the shorter Polynom's values 
			if (this.poly.get(i).getPow() > p.poly.get(j).getPow()) {//ith and jth value of this and p respectively are different
				pow[k] = (int) this.poly.get(i).getPow();
				coe[k] = this.poly.get(i).getCoe();
				i++;
			}
			else if (this.poly.get(i).getPow() < p.poly.get(j).getPow()) {//i-th and j-th values of this and p respectively are different		
				pow[k] = (int) p.poly.get(j).getPow();
				coe[k] = p.poly.get(j).getCoe();
				j++;
			}
			else {//i-th and j-th value of this and p respectively are the same
				pow[k] = (int) p.poly.get(j).getPow();
				coe[k] = p.poly.get(j).getCoe() + this.poly.get(i).getCoe();
				i++;
				j++;
			}
			k++;
		}
		// filling the rest of the values of the longer polynom
		if(i == thiSize) {
			while (j < pSize) {
				pow[k] = (int) p.poly.get(j).getPow();
				coe[k] = p.poly.get(j).getCoe();
				j++;
			}
		}
		else if(j == pSize) {
			while (i < thiSize) {
				pow[k] = (int) this.poly.get(i).getPow();
				coe[k] = this.poly.get(i).getCoe();
				i++;
			}
		}
	
		return new Polynom(pow, coe);	
	}
	
	
	//performing differentiation over the called polynom and return the differentiate polynom
	public Polynom differentiate() {
		// creating the new polynom's coefficient and power arrays
		int size = this.poly.size();
		int[] pow = new int[size];
		double[] coe = new double[size];
		
		for(int i = 0; i < size; i++) {
			coe[i] = this.poly.get(i).getCoe() * this.poly.get(i).getPow();
			pow[i] = (int) this.poly.get(i).getPow() -1;
		}
		return new Polynom(pow,coe);
		
	}
	
	// formalizing string for the calling polynom
	public String toString() {
		int size = this.poly.size();
		String s = new String();
		
		//don't add + to the first monom even if it's positive coefficient
		if(size > 0)
			s += this.poly.get(0).toString();
		else
			s += 0; // P = 0 
		
		//adding the rest of the monoms
		for(int i = 1; i < size; i++) {
			if(this.poly.get(i).getCoe() > 0) {// coefficient positive
				s += "+" + this.poly.get(i).toString();
			}
			else {// coefficient negative
				s += this.poly.get(i).toString();
			}			
		}
				
		return s;
	}
	
	
	// checks if Some object o is equal to the calling polynom
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Polynom)) // irrelevant object
			return false;
		
		Polynom p = (Polynom) o; 
		if (this.poly.size() != p.poly.size()) // not the same size no need further checks
			return false;
		
		for(int i = 0; i < p.poly.size();i++) { // matching each one of the monoms
			if(!(this.poly.get(i).equals(p.poly.get(i))))
				return false;
		}
		
		return true;
	}

}

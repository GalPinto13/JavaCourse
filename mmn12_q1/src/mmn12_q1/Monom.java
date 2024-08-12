package mmn12_q1;


/*class for creating each of the Monom to the Polynom be later consist from*/
public class Monom {
	// defining delta for in accuacncy due to floating point percision
	private final static double MIN_DELTA = 0.001;
	
	// attributes
	private double[] monom;
	
	// constructor each Monon consist from the power and a coefficient
	public Monom (int pow, double coe) {
		this.monom = new double[2];
		this.monom[0] = pow;
		this.monom[1] = coe;
		
	}
	//getters
	public int getPow() {
		return (int) this.monom[0];
	}
	
	public double getCoe() {
		return this.monom[1];
	}
	//setters
	public void setPow(double pow) {
		this.monom[0] = pow;
	}
	
	public void setCoe(double coe) {
		this.monom[1] = coe;
	}
	
	/* toString overriding from Object return the string rep of Monom*/
	public String toString() {
		// when the power is 0 we don't need the x^ prefix
		if(this.monom[0] == 0)
			return Double.toString(this.monom[1]);
		return this.monom[1] + "x^" + ((int) this.monom[0]);
	}
	
	/*comparing between two Monoms powers and coefficients to determine equality*/
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Monom)) // irrelevant object
			return false;
		Monom m = (Monom) o;
		return this.monom[0] == m.getPow() && (Math.abs(this.monom[1] - m.getCoe()) < MIN_DELTA);
	}
}

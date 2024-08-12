

public class InterestChecking extends NoServiceChargeChecking {
	//attributes
	final private static double DEFAULT_INTEREST = 0.1;
	private double interest;
	//Constructors
	public InterestChecking(String accNum, String accOwnName, String accOwnId, double balance) {
		super(accNum, accOwnName, accOwnId, balance);
		super.setminBalance(super.getminBalance() * 2);
		this.interest = DEFAULT_INTEREST;
	}
	
	public InterestChecking(String accNum, String accOwnName, String accOwnId, double balance, double interest) {
		super(accNum, accOwnName, accOwnId, balance);
		super.setminBalance(super.getminBalance() * 2);
		this.interest = interest;
	}
	//getteres
	public double getInterest() {
		return this.interest;
	}
	//setters
	public void setInterest(double interest) {
		this.interest = interest;
	}
	// compute the amount to add due to the interest
	public double calcInterest() {
		return this.getBalance() * this.interest;
	}
	//applying monthly management - adding money due to the interest
	public void monthlyManage() {
		this.setBalance(this.calcInterest() + this.getBalance());
	}
	
	public String toString() {
		return super.toString() + "\n" 
				+ "Account Interest: " + this.interest; 
	}
	
	public boolean equals(Object o) {
		if(o == null ||  !(o instanceof InterestChecking) || !(super.equals(o))) // irrelevant object
			return false;
		InterestChecking ic = (InterestChecking) o;
		return this.interest == ic.interest; 
	}
}

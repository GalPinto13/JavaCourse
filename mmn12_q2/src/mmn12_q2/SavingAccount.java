

public class SavingAccount extends BankAccount {
	//attributes
	final private static double DEFAULT_INTEREST = 0.1;
	private double interest;
	//constructors
	public SavingAccount(String accNum, String accOwnName, String accOwnId, double balance) {
		super(accNum, accOwnName, accOwnId, balance);
		this.interest = DEFAULT_INTEREST;
	}
	
	public SavingAccount(String accNum, String accOwnName, String accOwnId, double balance,  double interest) {
		super(accNum, accOwnName, accOwnId, balance);
		this.interest = interest;
	}
	//getters
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
	@Override
	public void monthlyManage() {
		this.setBalance(this.calcInterest()+ this.getBalance());
	}
	
	public String toString() {
		return super.toString() + "\n" 
				+ "Account Interest: " + this.interest; 
	}
	
	public boolean equals(Object o) {
		if(o == null ||  !(o instanceof SavingAccount) || !(super.equals(o))) // irrelevant object
			return false;
		SavingAccount sa = (SavingAccount) o;
		return this.interest == sa.interest; 
	}
	
}

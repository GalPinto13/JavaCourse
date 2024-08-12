

public class HighInterestSaving extends SavingAccount {
	//attributes
	final private static double DEFAULT_MIMIMUM_BALANCE = 20;
	final private static double DEFAULT_HIGH_INTEREST = 0.2;
	private double minBalance;
	private double interest;
	//Constructors
	public HighInterestSaving(String accNum, String accOwnName, String accOwnId, double balance) {
		super(accNum, accOwnName, accOwnId, balance, DEFAULT_HIGH_INTEREST);
		this.minBalance = DEFAULT_MIMIMUM_BALANCE;
	}
	
	public HighInterestSaving(String accNum, String accOwnName, String accOwnId, double balance, double minBalance, double interest) {
		super(accNum, accOwnName, accOwnId, balance, interest);
		this.minBalance = minBalance;
	}
	//getters
	public double getminBalance() {
		return this.minBalance;
	}
	//setters
	public void setminBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	
	public String toString() {
		return super.toString() + "\n" 
				+ "Account Minimum Balance: " + this.minBalance; 
	}
	
	public boolean equals(Object o) {
		if(o == null ||  !(o instanceof HighInterestSaving) || !(super.equals(o))) // irrelevant object
			return false;
		HighInterestSaving his = (HighInterestSaving) o;
		return this.interest == his.interest; 
	}
	// updating withdrawal for minimum balance
	public void withdrawal(double amount) {
		try {
			double newBalance = this.getBalance() - amount;
			if(newBalance < this.getminBalance())
				throw new IllegalBalance("withdrawal request canceled since the balance will be below the minimum");
			this.setBalance(newBalance);
		}
		catch (IllegalBalance e) {
			System.out.println("IllegalBalance Exception Cought: " +e.getMessage());	
		}
	}
}

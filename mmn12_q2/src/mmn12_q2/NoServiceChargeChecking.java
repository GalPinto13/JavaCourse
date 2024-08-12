

public class NoServiceChargeChecking extends CheckingAccount {
	//attributes
	final private static double DEFAULT_MIMIMUM_BALANCE = 10;
	private double minBalance;
	//Constructors
	public NoServiceChargeChecking(String accNum, String accOwnName, String accOwnId, double balance) {
		super(accNum, accOwnName, accOwnId, balance);
		this.minBalance = DEFAULT_MIMIMUM_BALANCE;
	}
	
	public NoServiceChargeChecking(String accNum, String accOwnName, String accOwnId, double balance, double minBalance) {
		super(accNum, accOwnName, accOwnId, balance);
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
	
	
	@Override 
	// There is no instructions for the monthly manage for this type of account
	public void monthlyManage() {
		// TODO Auto-generated method stub
	}
	
	//updating wrtieCheck to support the minimum balance functionality
	public void writeCheck(double checkAmount){
		try {
			double newBalance = this.getBalance() - checkAmount;
			if(newBalance < this.getminBalance())
				throw new IllegalBalance("writing check canceled since the balance will be below the minimum");
			this.setBalance(newBalance);
		}
		catch (IllegalBalance e) {
			System.out.println("IllegalBalance Exception Cought: " +e.getMessage());	
		}
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
	
	public String toString() {
		return super.toString() + "\n" 
				+ "Account Minimum Balance: " + this.minBalance; 
	}
	
	public boolean equals(Object o) {
		
		if(o == null || !(o instanceof NoServiceChargeChecking) || !(super.equals(o))) // irrelevant object
			return false;
		NoServiceChargeChecking nscc = (NoServiceChargeChecking) o;
		return this.minBalance == nscc.minBalance; 
	}

}

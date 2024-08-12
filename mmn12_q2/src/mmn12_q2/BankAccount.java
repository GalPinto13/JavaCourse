

public abstract class BankAccount {
	//General Bank Account attributes
	private String accNum;
	private String accOwnName;
	private String accOwnId;
	private double balance;
	
	//constructor
	public BankAccount(String accNum, String accOwnName, String accOwnId, double balance) {
		this.accNum = accNum;
		this.accOwnName = accOwnName;
		this.accOwnId = accOwnId;
		this.balance = balance;
	}
	// getters
	public String getaccNum() {
		return this.accNum;
	}
	
	public String getaccOwnName() {
		return this.accOwnName;
	}
	
	public String getaccOwnId() {
		return this.accOwnId;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	// setters
	public void setaccNum(String accNum) {
		this.accNum = accNum;
	}
	
	public void setaccOwnName(String accOwnName) {
		this.accOwnName = accOwnName;
	}
	
	public void setaccOwnId(String accOwnId) {
		this.accOwnId = accOwnId;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// add money to the acoount
	public void deposite(double amount) {
		if (amount > 0)
			this.setBalance(this.getBalance() + amount);
	}
	
	// withdrawal money from the account
	public void withdrawal(double amount) {
		try {
			double newBalance = this.getBalance() - amount;
			if(newBalance < 0)
				throw new IllegalBalance("withdrawal request canceled due to negative balance");
			this.setBalance(newBalance);
		}
		catch (IllegalBalance e) {
			System.out.println("IllegalBalance Exception Cought: " +e.getMessage());	
		}
	}
	
	// abstract method to be implement by child classes
	abstract public void monthlyManage();
	
	// formalizing the account details into string
	public String toString() {
		return "Account Number: " + this.accNum + "\n" 
				+ "Account Owner Name: " + this.accOwnName + "\n"
				+ "Account Owner ID: " + this.accOwnId + "\n"
				+ "Account Balance: " + this.balance; 	 
	}
	
	// check if two BankAccount objects are equals 
	public boolean equals(Object o) {
		if(o == null || !(o instanceof BankAccount)) // irrelevant object
			return false;
		BankAccount b = (BankAccount) o;
		return this.accNum.equals(b.accNum) && this.accOwnName.equals(b.accOwnName) && this.accOwnId.equals(b.accOwnId) && this.balance == b.balance; 
	}
}

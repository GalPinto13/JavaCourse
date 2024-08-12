

public abstract class CheckingAccount extends BankAccount {
	//constructor
	public CheckingAccount(String accNum, String accOwnName, String accOwnId, double balance) {
		super(accNum, accOwnName, accOwnId, balance);
	}
	// method for that's decrease the balance due to writing check, only if the account have enough money for it
	public void writeCheck(double checkAmount){
		try {
			double newBalance = this.getBalance() - checkAmount;
			if(newBalance < 0)
				throw new IllegalBalance("writing check canceled due to negative balance");
			this.setBalance(newBalance);
		}
		catch (IllegalBalance e) {
			System.out.println("IllegalBalance Exception Cought: " +e.getMessage());	
		}
	}
	
}

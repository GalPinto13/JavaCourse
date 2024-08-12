

public class ServiceChargeChecking extends CheckingAccount {
	
	private final static int DEFAULT_CHARGE = 10;
	private double charge;
	
	public ServiceChargeChecking(String accNum, String accOwnName, String accOwnId, double balance) {
		super(accNum, accOwnName, accOwnId, balance);
		this.charge = DEFAULT_CHARGE;
	}
	
	public ServiceChargeChecking(String accNum, String accOwnName, String accOwnId, double balance, double charge) {
		super(accNum, accOwnName, accOwnId, balance);
		this.charge = charge;
	}
	
	public double getCharge() {
		return this.charge;
	}
	
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	@Override
	public void monthlyManage() {
		this.setBalance(this.getBalance() - this.charge);
	}
	
	public String toString() {
		return super.toString() + "\n" 
				+ "Account Charge: " + this.charge; 
	}
	
	public boolean equals(Object o) {
		
		if(o == null || !(o instanceof ServiceChargeChecking) || !(super.equals(o))) // irrelevant object
			return false;
		ServiceChargeChecking scc = (ServiceChargeChecking) o;
		return this.charge == scc.charge; 
	}
}

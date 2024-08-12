package mmn12_q2;



public class Main {

	public static void main(String[] args) {
		// creating array of BankAccount with various types
		BankAccount[] arr = new BankAccount[20];
		// assigning various types
		arr[0] = new InterestChecking("6","Dor","142",5000,0.3); 
		arr[1] = new SavingAccount("8","Eden","1410",6000, 0.2);
		arr[2] = new HighInterestSaving("10","Idan","1412",1000);
		arr[3] = new NoServiceChargeChecking("4","Roni","144",750,100);
		arr[4] = new HighInterestSaving("9","Tamir","1412",1500,100,0.25);
		arr[5] = new ServiceChargeChecking("1","David","147",300);
		arr[6] = new SavingAccount("7","Eran","141",1000);
		arr[7] = new ServiceChargeChecking("2","Yosi","146",1000,20);
		arr[8] = new NoServiceChargeChecking("3","Gila","145",1500); 
		arr[9] = new InterestChecking("5","Yaniv","143",60000);
		// for testing equals
		arr[10] = new InterestChecking("6","Dor","142",5000,0.3); 
		arr[11] = new SavingAccount("8","Eden","1410",6000, 0.2);
		arr[12] = new HighInterestSaving("10","Idan","1412",1000);
		arr[13] = new NoServiceChargeChecking("4","Roni","144",750,100);
		arr[14] = new HighInterestSaving("9","Tamir","1412",1500,100,0.25);
		arr[15] = new ServiceChargeChecking("1","David","147",300);
		arr[16] = new SavingAccount("7","Eran","141",1000);
		arr[17] = new ServiceChargeChecking("2","Yosi","146",1000,20);
		arr[18] = new NoServiceChargeChecking("3","Gila","145",1500); 
		arr[19] = new InterestChecking("5","Yaniv","143",60000);
		
		
		//printing accounts details and their types
		System.out.println("#### Accounts Details ####");
		for(int i = 0; i < 10; i++) {
			if(arr[i] instanceof HighInterestSaving)
				System.out.println("Account Type: HighInterestSaving");
			else if (arr[i] instanceof SavingAccount)
				System.out.println("Account Type: SavingAccount");
			else if (arr[i] instanceof InterestChecking)
				System.out.println("Account Type: InterestChecking");
			else if (arr[i] instanceof NoServiceChargeChecking)
				System.out.println("Account Type: NoServiceChargeChecking");
			else if (arr[i] instanceof ServiceChargeChecking)
				System.out.println("Account Type: ServiceChargeChecking");
			System.out.println(arr[i].toString());
			System.out.println("#########################################");
		}
		
		
		//testing equals(Object o)
		System.out.println("#### Accounts Equals test: ####");
		for(int i = 0; i < 10; i++) {
			if(arr[i].equals(arr[i+10]))
				System.out.println("Account that positioned in the " + i + " place in the array is equal to the account position in the " + (i+10) + " place in the array");
			if(!(arr[i].equals(arr[i+1])))
				System.out.println("Account that positioned in the " + i + " place in the array is not equal to the account position in the " + (i+1) + " place in the array");
			System.out.println("#########################################");
		}
		
		//deposites
		System.out.println("#### Applying Deposite of 1000 to All Accounts ####");
		for(int i = 0; i < 10; i++) {
			System.out.println("Before deposite:");
			System.out.println("----------------");
			System.out.println(arr[i].toString());
			arr[i].deposite(1000);
			System.out.println("After deposite:");
			System.out.println("---------------");
			System.out.println(arr[i].toString());
			System.out.println("#########################################");
		}
		
		
		//withdrawals
		System.out.println("#### Attempting Withdrawal 2000 from all accounts ####");
		for(int i = 0; i < 10; i++) {
			System.out.println("Before withdrawal:");
			System.out.println("------------------");
			System.out.println(arr[i].toString());
			arr[i].withdrawal(2000);
			System.out.println("After withdrawal:");
			System.out.println("-----------------");
			System.out.println(arr[i].toString());
			System.out.println("#########################################");
		}
		
		//Writing Checks
		System.out.println("#### Writing Checks of 2000 to supported accounts ####");
		for(int i = 0; i < 10; i++) {
			if(arr[i] instanceof CheckingAccount) {
				CheckingAccount ca = (CheckingAccount) arr[i];
				System.out.println("Before applying check:");
				System.out.println("----------------------");
				System.out.println(ca.toString());
				ca.writeCheck(2000);
				System.out.println("After applying Check:");
				System.out.println("---------------------");
				System.out.println(ca.toString());
			}
			else
				System.out.println("Account Number " + arr[i].getaccNum() + " is not from Checking type");
			System.out.println("#########################################");
		}
		
		//Monthly management
		System.out.println("#### Applying Monthly Management for all accounts ####");
		for(int i = 0; i < 10; i++) {
			System.out.println("Before Monthly Management:");
			System.out.println("--------------------------");
			System.out.println(arr[i].toString());
			arr[i].monthlyManage();
			System.out.println("After Monthly Management:");
			System.out.println("--------------------------");
			System.out.println(arr[i].toString());
			System.out.println("#########################################");
		}

	}

}

package mmn15_q1;


/* the class of the worker */
public class PrimeWorkers extends Thread {
	private PrimePool p;
	private int workerNum;
	public PrimeWorkers(PrimePool p, int workerNum) {
		this.p = p;
		this.workerNum = workerNum;
	}
	
	
	public void run() {
		super.run();
		boolean isPrime;
		int number = p.getNumToCheck();
		while(number > 0) {
			System.out.println("Worker number: " + workerNum + " takes number: " + number + " for work"); // tracking the worker status in Main
			isPrime = isPrime(number);
			p.applyResults(number, isPrime);
			System.out.println("Worker number: " + workerNum + " has fininsed working on number: " + number); // tracking the worker status in Main
			number = p.getNumToCheck();
		}
		System.out.println("Worker number: " + workerNum + " has fininsed its job "); // tracking the worker status in Main
		
	}
	
	private boolean isPrime(int number) {
		if (number == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0)
				return false;
		}
		return true;
		
	}

}

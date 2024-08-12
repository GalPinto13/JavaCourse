package mmn15_q1;
/* the monitor that reposibile for conrtolling the current number to work on and give numbers to workers */
public class PrimePool {
	private boolean[] results;
	private int currentNum = 1; // the number that no thread has worked on
	private int doneNum = 0; // the amount of numbers that being checked at the moment
	private int limitNum; // the m parameter
	
	public PrimePool(int m) {
		this.results = new boolean[m];
		limitNum = m;
	}
	
	public synchronized int getNumToCheck() {
		if (currentNum > limitNum)
			return 0;
		return currentNum++;		
	}
	
	public synchronized void applyResults(int number, boolean isPrime) {
		if (isPrime)
			results[number - 1] = true;
		doneNum++;
		notifyAll();// wake up threads that wait on printResults	
	}
	
	public synchronized String printResults() {
		// waiting until all threads are finished
		while( doneNum != limitNum) {
			try {wait();}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		String s = "";
		s += "The prime numbers between 1 and " + limitNum + " are:\n";
		for (int i = 0; i < results.length -1; i++) {
			if(results[i])
				s += (i + 1) + ", ";
		}
		s = s.substring(0, s.length() -2); // removing the last comma
		return s;
	}
}

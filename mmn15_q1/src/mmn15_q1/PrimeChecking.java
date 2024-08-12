package mmn15_q1;
/* the class for initialized the workers and calculating the prime numbers */
public class PrimeChecking {
	public static void PrimeList(int m, int n) {
		PrimePool p = new PrimePool(m);
		PrimeWorkers[] workers = new PrimeWorkers[n];
		// initializing the threads
		for (int i = 0; i < n; i++) {
			workers[i] = new PrimeWorkers(p, i+1);
		}
		// activating the threads
		for (int i = 0; i < n; i++) {
			workers[i].start();
		}
		// wait for all threads to finish before printing 
		for (int i = 0; i < n; i++) {
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n" + "---------------------------------------------");
		System.out.println(p.printResults());
	}
}

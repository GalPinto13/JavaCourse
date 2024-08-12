package mmn15_q2;

/* the monitor for the shared Sticks*/
public class Sticks {
	private boolean[] sticks;

	public Sticks() {
		this.sticks = new boolean[5];
	}

	/* requesting a stick, if the stick is already taken, then wait */
	public synchronized void takeStick(int stickIndex) {
		while (sticks[stickIndex]) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sticks[stickIndex] = true;
	}

	/* threads the finish return its sticks */
	public synchronized void releaseStick(int firstStick, int secondStick) {
		sticks[firstStick] = false;
		sticks[secondStick] = false;
		notifyAll();
	}

}

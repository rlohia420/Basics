package Thread.communication.blockingQueue.deadAndLiveLock;

public class Police {

	private boolean moneySent = false;
	public void giveRansom(Criminal criminal) {
		System.out.println("Release hostage ");
		while(!criminal.hostageRelease()) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			this.moneySent = true;
		}
	}
	public boolean isMoneySent() {
		return this.moneySent;
	}
}

package Thread.communication.blockingQueue.deadAndLiveLock;

public class HostageRescueLiveLock {

	public static final Police police = new Police();
	public static final Criminal criminal = new Criminal();
	public static void main(String args[]) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				police.giveRansom(criminal);
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				criminal.releaseHostage(police);
			}
		});
		t1.start();
		t2.start();
	}
}

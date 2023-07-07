package Thread.communication.blockingQueue.deadAndLiveLock;

public class Deadlock {

	public static void main(String args[]) {
		final String resource1 = "Neha";
		final String resource2 = "Lohia";
		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("resource1" + resource1);

					synchronized (resource2) {
						System.out.println("resource2" + resource2);
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("resource2" + resource2);

					synchronized (resource1) {
						System.out.println("resource1" + resource1);
					}
				}
			}
		};

		t1.start();
		t2.start();
	}
}

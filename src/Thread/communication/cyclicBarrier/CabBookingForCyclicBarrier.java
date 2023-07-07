package Thread.communication.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CabBookingForCyclicBarrier {

	private static CyclicBarrier cb = new CyclicBarrier(3);
	public static void main(String args[]) {
		CabService cabService = new CabService(cb);
		Thread t1 = new Thread(cabService,"t1");
		Thread t2 = new Thread(cabService,"t2");
		Thread t3 = new Thread(cabService,"t3");
		Thread t4 = new Thread(cabService,"t4");
		Thread t5 = new Thread(cabService,"t5");
		Thread t6 = new Thread(cabService,"t6");
		t1.start();
		t2.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

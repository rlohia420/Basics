package Thread.communication.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class FoodDeliver {

	public static void main(String args[]) {
		final CountDownLatch latch = new CountDownLatch(3);
		Thread t1 = new Thread(new FoodProcessor(latch, args));
		t1.start();
		try {
			System.out.println("oredr receievd");
			latch.await();
			System.out.println("order prepared");
		}catch(InterruptedException e) {
			
		}
	}
}

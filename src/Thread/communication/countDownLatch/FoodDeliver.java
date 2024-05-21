package Thread.communication.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class FoodDeliver {

	public static void main(String args[]) {
		final CountDownLatch latch = new CountDownLatch(3);
		String[] foodItems = {"PIZZA","BURGER","COKE"};
		Thread t1 = new Thread(new FoodProcessor(latch, foodItems));
		t1.start();
		try {
			System.out.println("order receievd");
			latch.await();
			System.out.println("order prepared , Not start delivering in main thread");

		}catch(InterruptedException e) {
			
		}
	}
}

package Thread.communication.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class FoodProcessor implements Runnable{

	private  final CountDownLatch latch ;
	private  final String[] noOfItemsOrdered;
	
	public FoodProcessor(CountDownLatch latch,String[] noOfItemsOrdered ){
		this.latch=latch;
		this.noOfItemsOrdered=noOfItemsOrdered;
	}
	@Override
	public void run() {
		for(int i=0;i<noOfItemsOrdered.length;i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Before process "+latch.getCount());
				System.out.println("item = "+noOfItemsOrdered[i]+" prepared");
				latch.countDown();
				System.out.println("after process");
			}catch(InterruptedException e) {
				
			}
		}
	}
	
}

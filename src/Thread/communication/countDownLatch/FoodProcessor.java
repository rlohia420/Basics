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
				Thread.sleep(100);
				System.out.println("Before preparing "+noOfItemsOrdered[i]+" , latch is = "+latch.getCount());
				//System.out.println("item = "+noOfItemsOrdered[i]+" prepared");
				latch.countDown();
				System.out.println("After preparing "+noOfItemsOrdered[i]+" , latch is = "+latch.getCount());
			}catch(InterruptedException e) {
				
			}
		}
	}
	
}

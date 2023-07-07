package Thread.communication.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CabService implements Runnable {
	private CyclicBarrier cyclicBarrier;

	public CabService(CyclicBarrier cyclicBarrier) {
		super();
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread() + " Entered ");
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		//Below statement will not be executed until 3 thread will be reached at this point
		System.out.println(Thread.currentThread() + " Exiting ");
	}
}

package Thread.communication.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class NetworkHealthChecker extends BaseHealthChecker{

	public NetworkHealthChecker(CountDownLatch latch) {
		super("Network service - ",latch);
	}

	@Override
	public void verifyService() {
		System.out.println("Checking "+this.getServiceName());
		try {
			Thread.sleep(7000);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println(this.getServiceName() + "is Up.");
	}
	

}

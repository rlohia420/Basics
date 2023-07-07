package Thread.communication.countDownLatch;

import java.util.concurrent.CountDownLatch;

public abstract class BaseHealthChecker implements Runnable{

	private CountDownLatch latch ;
	private String serviceName;
	private boolean serviceUp;
	
	public BaseHealthChecker(String serviceName,CountDownLatch latch) {
		super();
		this.latch = latch;
		this.serviceName = serviceName;
		this.serviceUp = false;
	}
	public String getServiceName() {
		return serviceName;
	}
	public boolean isServiceUp() {
		return serviceUp;
	}

	@Override
	public void run() {
		try {
		verifyService();
		serviceUp  = true;
		}catch(Throwable th) {
			th.printStackTrace();
			serviceUp = false;
		}finally {
			if(latch!=null) {
				latch.countDown();
			}
		}
	}

	public abstract void verifyService();
}

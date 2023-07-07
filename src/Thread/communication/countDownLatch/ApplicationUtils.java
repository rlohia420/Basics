package Thread.communication.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApplicationUtils {

	private static List<BaseHealthChecker> services;
	private static CountDownLatch latch;
	private ApplicationUtils() {}
	private final static ApplicationUtils instance = new ApplicationUtils();
	public static ApplicationUtils getInstance() {
		return instance;
	}
	public static boolean checkExternakService() {
		latch = new CountDownLatch(3);
		
		services = new ArrayList<>();
		services.add(new NetworkHealthChecker(latch));
		services.add(new CacheHealthChecker(latch));
		services.add(new DatabaseHealthChecker(latch));
		
		Executor ex = Executors.newFixedThreadPool(services.size());
		for(BaseHealthChecker healthCheckerService: services) {
			ex.execute(healthCheckerService);
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(BaseHealthChecker healthCheckerService: services) {
			if(!healthCheckerService.isServiceUp()) {
				return false;
			}
		}
		return true;
		
	}
}

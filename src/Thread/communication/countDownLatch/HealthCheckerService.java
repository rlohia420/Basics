package Thread.communication.countDownLatch;

public class HealthCheckerService {

	public static void main(String args[]) {
		boolean result = false;
		try {
			result = ApplicationUtils.checkExternakService();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Validation is completed "+result);
		
		System.out.println("Now i can start application !!!!!");
	}
}

package Thread.Threadpoolexecutor;

public class Task implements Runnable {

	private int number;
	public Task(int number) {
		this.number = number;
	}
	@Override
	public void run() {
		System.out.println(number);
		try {
			Thread.sleep(100);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(number);
	}
}

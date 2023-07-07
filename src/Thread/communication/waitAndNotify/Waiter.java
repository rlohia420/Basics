package Thread.communication.waitAndNotify;

public class Waiter implements Runnable{
	private Message msz ;
	
	public Waiter(Message msz ) {
		this.msz = msz;
	}
	
	@Override
	public void run() {
		synchronized (msz) {
			try {
				System.out.println("Waiting for the resource");
				msz.wait();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

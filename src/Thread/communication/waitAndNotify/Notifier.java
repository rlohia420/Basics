package Thread.communication.waitAndNotify;

public class Notifier implements Runnable{

	private Message msz ;

	public Notifier(Message msz ) {
		this.msz = msz;
	}
	
	@Override
	public void run() {
		synchronized (msz) {
			try {
				System.out.println("Processing using the resource");
				msz.notify();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

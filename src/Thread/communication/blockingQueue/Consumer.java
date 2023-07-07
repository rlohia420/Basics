package Thread.communication.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
private BlockingQueue<Message> blockingQueue;
	
	public Consumer(BlockingQueue<Message> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		Message msz = null;
		try {
			while(!(msz = blockingQueue.take()).getMsz().equals("exit")) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Consumed "+msz.getMsz());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

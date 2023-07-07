package Thread.communication.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private BlockingQueue<Message> blockingQueue;
	
	public Producer(BlockingQueue<Message> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			Message m = new Message(""+i);
			try {
				Thread.sleep(1);
				blockingQueue.put(m);
				System.out.println("produced "+m.getMsz());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			blockingQueue.put(new Message("exit"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

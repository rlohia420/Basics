package Thread.Threadpoolexecutor;

public class TaskExecutor implements Runnable{

	BlockingQueueThreadPool<Runnable> queue ;
	public TaskExecutor(BlockingQueueThreadPool<Runnable> b) {
		this.queue=b;
	}
	@Override
	public void run() {
		try {
			while(true) {
				String name = Thread.currentThread().getName();
				Runnable task = queue.deque();
				System.out.println(name);
				task.run();
				System.out.println(name);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package Thread.Threadpoolexecutor;

public class ThreadPool {

	BlockingQueueThreadPool<Runnable> queue;
	public ThreadPool(int queueSize, int n) {
		queue = new BlockingQueueThreadPool<Runnable>(queueSize);
		String threadName = null;
		TaskExecutor taskExecutor = null;
		for(int count=0;count<n;count++) {
			threadName = "Thread "+count;
			taskExecutor = new TaskExecutor(queue);
			Thread thread = new Thread(taskExecutor,threadName);
			thread.start();
		}
	}
	public void submitTask(Runnable task) {
		try {
			queue.enque(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

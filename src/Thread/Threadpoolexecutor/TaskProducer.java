package Thread.Threadpoolexecutor;

public class TaskProducer {

	public static void main(String args[]) {
		ThreadPool threadPool = new ThreadPool(3, 4);
		Task task = null;
		for(int i=1;i<=7;i++) {
			 task = new Task(i);
		}
		threadPool.submitTask(task);
	}
	
}

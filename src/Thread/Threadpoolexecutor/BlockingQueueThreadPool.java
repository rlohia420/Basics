package Thread.Threadpoolexecutor;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueueThreadPool<Type> {
	private Queue queue = new LinkedList<>();
	private int empty = 0;
	private int max =-1;
	public BlockingQueueThreadPool(int size){
		this.max = size;
	}
	public synchronized void enque(Type task) throws InterruptedException {
		while(this.queue.size()==this.max) {
			wait();
		}
		if(this.queue.size()==empty) {
			notifyAll();
		}
		this.queue.offer(task);
	}
	
	public synchronized Type deque() throws InterruptedException {
		while(this.queue.size()==this.empty) {
			wait();
		}
		if(this.queue.size()==this.max) {
			notifyAll();
		}
		return (Type) this.queue.poll();
	}
}

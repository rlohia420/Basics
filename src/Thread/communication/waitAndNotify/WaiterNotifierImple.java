package Thread.communication.waitAndNotify;

public class WaiterNotifierImple {

	public static void main(String args[]) {
		Message m1 = new Message("Neha");
		Thread t1 = new Thread(new Waiter(m1));
		Thread t2 = new Thread(new Notifier(m1));
		t1.start();
		t2.start();
	}
}

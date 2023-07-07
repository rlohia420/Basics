package Thread.communication.blockingQueue.deadAndLiveLock;

public class Criminal {

	private boolean hostageRelease = false;

	public void releaseHostage(Police police) {
		System.out.println("Give money ");
		while (!police.isMoneySent()) {
			try {
				Thread.sleep(100);
			}catch(Exception e) {
				e.printStackTrace();
			}
			this.hostageRelease=true;
		}
	}

	public boolean hostageRelease() {
		return this.hostageRelease;
	}
}

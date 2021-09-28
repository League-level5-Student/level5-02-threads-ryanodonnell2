package _06_Wait_and_Notify.Practice;

public class RunSplitLoops {
	public static void main(String[] args) {
		Thread t1 = new Thread(new SynchedSplitLoops());
		
		Thread t2 = new Thread(new SynchedSplitLoops());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.err.println("Could not join threads");
		}
		
	}
}

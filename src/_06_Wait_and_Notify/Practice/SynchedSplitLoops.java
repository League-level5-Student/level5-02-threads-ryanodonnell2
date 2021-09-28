package _06_Wait_and_Notify.Practice;

/*
 
Below are two threads. One thread increments the counter
and the other thread prints the result. If you run the
program as it is, you'll notice that the output in not
sequential.

Your goal is to modify the code inside the threads so that 
they are in synch. Use synchronized, wait, and notify to make
it so that t1 will only increase counter after t2 has printed 
the previous result. The output should be the numbers 0 to 100000
printed in order.
  
*/

public class SynchedSplitLoops implements Runnable {
	static Object threadLock = new Object();
	static int counter = 0;
	
	static int totalThreads = 0;
	private int thread;
	public SynchedSplitLoops() {
		totalThreads++;
		thread = totalThreads;
	}
	

	@Override
	public void run() {
		while(counter<=100000) {
			synchronized(threadLock) { //locks this block of code if another thread is using threadLock
				if(thread==2) {
					counter++;
				}
				else {
					System.out.println(counter);
				}
				threadLock.notify();
				try {
					threadLock.wait(); //pauses execution until another thread calls notify using threadLock
				} catch (InterruptedException e) {
					System.out.println("error!");
				}
			}
		}
		
	}
}

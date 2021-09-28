package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {

	private int threadNum;
	
	public ThreadedGreeter(int i) {
		// TODO Auto-generated constructor stub
		threadNum = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread "+threadNum);
		if(threadNum<=50) {
			Thread t = new Thread(new ThreadedGreeter(threadNum+1));
			
			//6. Start and join the thread. Did you get the required output?
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

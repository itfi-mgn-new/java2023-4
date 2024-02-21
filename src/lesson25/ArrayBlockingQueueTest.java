package lesson25;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final ArrayBlockingQueue<String>	q = new ArrayBlockingQueue<>(10);
	
		Thread t1 = new Thread(()->{
			try {
				for (int index = 0; index < 30; index++) {
					System.err.println("Before put");
					q.put("index "+index);
					System.err.println("After put");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		
		for(int index = 0; index < 30; index++) {
			Thread.sleep(1000);
			System.err.println("Msg: "+q.take());
		}
	}
}

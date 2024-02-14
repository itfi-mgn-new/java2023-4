package lesson23;

import java.io.IOException;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// jsr-133, jvm chapter 17
		// 
		Thread	t1 = new Thread(()->{
					while (!Thread.interrupted()) {
						System.err.println("Thread 1 "+Thread.currentThread().getName());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							break;
						}
					}
				});
		Thread	t2 = new Thread(()->{
				System.err.println("Thread 2 "+Thread.currentThread().getName());
				});
		Thread	t3 = new Thread(()->{
					System.err.println("Thread 3 "+Thread.currentThread().getName());
				});
		t1.setName("My thread");
//		t1.setDaemon(true);
		t1.start();
		t2.start();
		t3.start();
//		Thread.sleep(5000);
		t1.interrupt();
//		t1.stop();
		t1.join();
		t2.join();
		t3.join();
		System.err.println("Current: "+Thread.currentThread().getName());
	}
}

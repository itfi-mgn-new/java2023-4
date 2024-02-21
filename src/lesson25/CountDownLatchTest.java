package lesson25;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final CountDownLatch	latch = new CountDownLatch(1);
		Thread	t1 = new Thread(()->{
						System.err.println("Thread 1 before");
						try {
							latch.await();
						} catch (InterruptedException e) {
						}
						System.err.println("Thread 1 after");
				});
		Thread	t2 = new Thread(()->{
				System.err.println("Thread 2 before");
				try {
					latch.await();
				} catch (InterruptedException e) {
				}
				System.err.println("Thread 2 after");
		});
		Thread	t3 = new Thread(()->{
				System.err.println("Thread 3 before");
				try {
					latch.await();
				} catch (InterruptedException e) {
				}
				System.err.println("Thread 3 after");
		});
		t1.start();
		t2.start();
		t3.start();
		Thread.sleep(1000);
		System.err.println("BEfore barrier");
		latch.countDown();
		System.err.println("After barrier");
	}

}

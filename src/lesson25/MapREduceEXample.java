package lesson25;

import java.util.concurrent.CountDownLatch;

public class MapREduceEXample {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch	start = new CountDownLatch(1);
		final CountDownLatch	end = new CountDownLatch(3);
		final int[]				result= new int[3];

		Thread t1 = new Thread(()->{
			// kljkjklj
			try {
				start.await();
				Thread.sleep(1000);
				result[0] = 2 * result[0];
			} catch (InterruptedException e) {
			} finally {
				end.countDown();
			}
			// kjhkjhkjhjk
		});
		Thread t2 = new Thread(()->{
			try {
				start.await();
				Thread.sleep(1000);
				result[1] = 2 * result[1];
			} catch (InterruptedException e) {
			} finally {
				end.countDown();
			}
		});
		Thread t3 = new Thread(()->{
			try {
				start.await();
				Thread.sleep(1000);
				result[2] = 2 * result[2];
			} catch (InterruptedException e) {
			} finally {
				end.countDown();
			}
		});
		t1.start();
		t2.start();
		t3.start();
		result[0] = 100;
		result[1] = 200;
		result[2] = 300;
		start.countDown();
		Thread.sleep(1000);
		end.await();
		System.err.println("REsult = "+(result[0]+result[1]+result[2]));
	}

}

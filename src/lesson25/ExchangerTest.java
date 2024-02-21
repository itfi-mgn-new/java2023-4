package lesson25;

import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		final Exchanger<String>	ex = new Exchanger<>();
		
		Thread	t1 = new Thread(()->{
				try {
					Thread.sleep((long) (1000 * Math.random()));
					System.err.println("Thread 1: "+ex.exchange("vassya"));
				} catch (InterruptedException e) {
				}
		}); 
		Thread	t2 = new Thread(()->{
				try {
					Thread.sleep((long) (1000 * Math.random()));
					System.err.println("Thread 2: "+ex.exchange("pupkin"));
				} catch (InterruptedException e) {
				}
		}); 
		t1.start();
		t2.start();
	}

}

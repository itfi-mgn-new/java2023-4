package lesson25;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Exchanger<Integer>	ex = new Exchanger<>();
		
		Thread	t1 = new Thread(()->{
					for(int index = 0; index < 100; index++) {
						try {
							synchronized(ex) {
								ex.exchange(2);
							}
						} catch (InterruptedException e) {
						}
					}
				});
		Thread	t2 = new Thread(()->{
					for(int index = 0; index < 100; index++) {
						try {
							synchronized(ex) {
								ex.exchange(2);
							}
						} catch (InterruptedException e) {
						}
					}
				});
		Thread	t3 = new Thread(()->{
					for(int index = 0; index < 100; index++) {
						try {
							synchronized(ex) {
								ex.exchange(2);
							}
						} catch (InterruptedException e) {
						}
					}
				});
		Thread	r = new Thread(()->{
						int sum = 0;
						for(int index = 0; index < 300; index++) {
							try {
								sum += ex.exchange(null);
							} catch (InterruptedException e) {
							}
						}
						System.err.println("Sum="+sum);
				});
		t1.start();
		t2.start();
		t3.start();
		r.start();
	}

}

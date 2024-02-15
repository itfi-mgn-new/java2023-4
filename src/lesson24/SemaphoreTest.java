package lesson24;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	static volatile int x = 0;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Semaphore	sema = new Semaphore(1);
		
		Thread t1 = new Thread(()->{
				for(int index = 0; index < 100000; index++) {
					try {
						sema.acquire();	// synchronized(sema) {
						x++;
					} catch (InterruptedException e) {
						break;
					} finally {
						sema.release();	// }
					}
				}
			});
		Thread t2 = new Thread(()->{
					for(int index = 0; index < 100000; index++) {
						try {
							sema.acquire();	// synchronized(sema) {
							x++;
						} catch (InterruptedException e) {
							break;
						} finally {
							sema.release();	// }
						}
					}
				});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.err.println("X="+x);		
	}

}

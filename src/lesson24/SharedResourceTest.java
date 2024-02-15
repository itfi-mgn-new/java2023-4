package lesson24;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResourceTest {
	static volatile int	x = 0;
	static volatile int	y = 0;
	static final Object sync = new Object();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ReentrantReadWriteLock	rrw = new ReentrantReadWriteLock(); 
		
		Thread t1 = new Thread(()->{
					for(int index = 0; index < 1000000; index++) {
						try{
							rrw.writeLock().lock(); // synchronized(rrw) {
							x = index % 2 == 0 ? 6 : 7;
						} finally {
					         rrw.writeLock().unlock(); // Unlock write, still hold read
					     }
						//System.err.println("X="+x);
					}
				});
		Thread t2 = new Thread(()->{
					// calculate();
					for(int index = 0; index < 50000000; index++) {
						int y;
						try{
							rrw.readLock().lock();	// synchronized(rrw) {
							y = x * x;
						} finally {
							rrw.readLock().unlock(); // }
						}
						if (y != 36 && y != 49) {
							System.err.println("X*X="+(y));
						}
					}
				});
			Thread t3 = new Thread(()->{
				// calculate();
				for(int index = 0; index < 50000000; index++) {
					int y;
					try{
						rrw.readLock().lock();	// synchronized(rrw) {
						y = x * x;
					} finally {
						rrw.readLock().unlock(); // }
					}
					if (y != 36 && y != 49) {
						System.err.println("!!!!! X*X="+(y));
					}
				}
			});
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();

	}

}

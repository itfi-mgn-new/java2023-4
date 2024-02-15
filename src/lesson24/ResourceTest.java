package lesson24;

public class ResourceTest {
	static volatile int	x = 0;
	static final Object sync = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(()->{
						for(int index = 0; index < 100000; index++) {
							// jkjhkjhkjhkjhkj
							synchronized(sync) {
								x++;
							}
						}
					});
		x = 10;
		Thread t2 = new Thread(()->{
						for(int index = 0; index < 100000; index++) {
							// dkljlksdjflkjdflkj
							synchronized(sync) {
								// try {
								// 	aload obj
								// 	monitorenter
								x++;
							}
							// finally {
							// 	aload obj
							// 	monitorexit
							// }
						}
					});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.err.println("X="+x);
	}

	public static synchronized void call() {
		// synchronized(ResourceTest.class) {
//		synchronized(sync) {
			//  dflgjlkdfjglkjglkjdlkfgjkldjfglkjd
//		}
		// }
	}
	
	public synchronized void callInstance() {
		// synchronized(this) {
//		synchronized(sync) {
			//  dflgjlkdfjglkjglkjdlkfgjkldjfglkjd
//		}
		// }
	}

}

package lesson24;

public class DijkstraTask {
	static final Object stick1 = new Object();
	static final Object stick2 = new Object();
	static final Object stick3 = new Object();
	static final Object stick4 = new Object();
	static final Object stick5 = new Object();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread	t1 = new Thread(()->{
							for(;;) {
								try{
									eat(stick1, stick2);
									thinking();
								} catch (InterruptedException e) {
									break;
								}
							}
						});
		Thread	t2 = new Thread(()->{
							for(;;) {
								try{
									eat(stick2, stick3);
									thinking();
								} catch (InterruptedException e) {
									break;
								}
							}
						});
		Thread	t3 = new Thread(()->{
							for(;;) {
								try{
									eat(stick3, stick4);
									thinking();
								} catch (InterruptedException e) {
									break;
								}
							}
						});
		Thread	t4 = new Thread(()->{
							for(;;) {
								try{
									eat(stick4, stick5);
									thinking();
								} catch (InterruptedException e) {
									break;
								}
							}
						});
		Thread	t5 = new Thread(()->{
							for(;;) {
								try{
									eat(stick1, stick5);
									thinking();
								} catch (InterruptedException e) {
									break;
								}
							}
						});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	private static void eat(final Object left, final Object right) throws InterruptedException {
		synchronized(left) {
			synchronized(right) {
//				Thread.sleep(1000);
				System.err.println("Thread: "+Thread.currentThread().getName()+" eating");
			}
		}
	}

	private static void thinking() throws InterruptedException {
//		Thread.sleep(5000);
		System.err.println("Thread: "+Thread.currentThread().getName()+" thinking");
	}
	
}

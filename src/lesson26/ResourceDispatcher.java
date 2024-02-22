package lesson26;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ResourceDispatcher implements AutoCloseable {
	private final ArrayBlockingQueue<Message>	queue = new ArrayBlockingQueue<>(10);
	private final Thread						t = new Thread(()->start());
	
	public ResourceDispatcher() {
		t.setDaemon(true);
		t.setName("Resource dispatcher");
		t.start();
	}

	@Override
	public void close() throws RuntimeException {
		t.interrupt();
	}
	
	
	public void allocate(final int left, final int right) throws InterruptedException {
		send(new Message(true, left, right));
	}
	
	public void free(final int left, final int right) throws InterruptedException {
		send(new Message(false, left, right));
	}

	private void start() {
		final boolean[]		sticks = new boolean[] {false, false, false, false, false};
		final List<Message>	unprocessed = new ArrayList<>();
		
		while (!Thread.interrupted()) {
			try{
				final Message	msg = queue.take();
				
				if (msg.allocate) {
					if (!sticks[msg.left] && !sticks[msg.right]) {
						sticks[msg.left] = true;
						sticks[msg.right] = true;
						msg.latch.countDown();
					}
					else {
						unprocessed.add(0, msg);
					}
				}
				else {
					sticks[msg.left] = false;
					sticks[msg.right] = false;
					msg.latch.countDown();
					for(int index = unprocessed.size() - 1; index >= 0; index--) {
						final Message	m = unprocessed.get(index);
						
						if (!sticks[m.left] && !sticks[m.right]) {
							sticks[m.left] = true;
							sticks[m.right] = true;
							unprocessed.remove(index).latch.countDown();
						}
					}
				}
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	
	private void send(final Message msg) throws InterruptedException {
		queue.put(msg);
		msg.latch.await();
	}
	
	
	private static class Message {
		final boolean			allocate;
		final int				left, right;
		final CountDownLatch	latch = new CountDownLatch(1);

		public Message(boolean allocate, int left, int right) {
			this.allocate = allocate;
			this.left = left;
			this.right = right;
		}
	}

	
	public static final int		stick1 = 0;
	public static final int		stick2 = 1;
	public static final int		stick3 = 2;
	public static final int		stick4 = 3;
	public static final int		stick5 = 4;
	

	public static void main(String[] args) throws InterruptedException {
		try(final ResourceDispatcher rd = new ResourceDispatcher()) {
			final ThreadGroup	g = new ThreadGroup("chinese");
			final Thread		t1 = new Thread(g, ()->{
										while(!Thread.interrupted()) {
											try{
												eat(rd, stick1, stick2);
												thinking();
											} catch (InterruptedException e) {
												break;
											}
										}
									});
			final Thread		t2 = new Thread(g, ()->{
										while(!Thread.interrupted()) {
											try{
												eat(rd, stick2, stick3);
												thinking();
											} catch (InterruptedException e) {
												break;
											}
										}
									});
			final Thread		t3 = new Thread(g, ()->{
										while(!Thread.interrupted()) {
											try{
												eat(rd, stick3, stick4);
												thinking();
											} catch (InterruptedException e) {
												break;
											}
										}
									});
			final Thread		t4 = new Thread(g, ()->{
										while(!Thread.interrupted()) {
											try{
												eat(rd, stick4, stick5);
												thinking();
											} catch (InterruptedException e) {
												break;
											}
										}
									});
			final Thread	t5 = new Thread(g, ()->{
										while(!Thread.interrupted()) {
											try{
												eat(rd, stick5, stick1);
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
			
			Thread.sleep(30000);
			g.interrupt();
		}
	}
	
	private static void eat(final ResourceDispatcher rd, final int left, final int right) throws InterruptedException {
		rd.allocate(left, right);
		System.err.println("Thread: "+Thread.currentThread().getName()+" eating");
		Thread.sleep(1000);
		rd.free(left, right);
	}

	private static void thinking() throws InterruptedException {
		System.err.println("Thread: "+Thread.currentThread().getName()+" thinking");
		Thread.sleep(5000);
	}
}

package lesson25;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Service {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final ArrayBlockingQueue<Message>	q = new ArrayBlockingQueue<>(10);
		final CountDownLatch				latch = new CountDownLatch(2);

		final Thread	t1 = new Thread(()->{
							for(int index = 0; index < 100; index++) {
								send(q, "thread 1");
							};
							latch.countDown();
						});
		final Thread	t2 = new Thread(()->{
							for(int index = 0; index < 100; index++) {
								send(q, "thread 2");
							};
							latch.countDown();
						});
		final Thread	r = new Thread(()->service(q));

		t1.start();
		t2.start();
		r.start();
		
		latch.await();
		r.interrupt();
	}

	private static void service(final ArrayBlockingQueue<Message> q) {
		while (!Thread.interrupted()) {
			try {
				final Message	m = q.take();
				
				Thread.sleep(100);
				m.result = m.source.toUpperCase();
				m.event.countDown();
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	private static void send(final ArrayBlockingQueue<Message> q, final String source) {
		try {
			final Message m = new Message(source);

			q.put(m);
			System.err.println("result="+m.getResult());
		} catch (InterruptedException e) {
		}
	}

	static class Message {
		final String			source;
		volatile String			result;
		final CountDownLatch	event = new CountDownLatch(1);
		
		public Message(String source) {
			this.source = source;
		}

		public String getResult() throws InterruptedException {
			event.await();
			return result;
		}
	}
}

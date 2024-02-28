package lesson26;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		
		executor.execute(()->{System.err.println("sldkskd");});
		//Thread.sleep(100);
		System.err.println("sdsd");
		final Exchanger<String>  ex = new Exchanger<>();
		
		
		Future<String> s = executor.submit(new Callable<String>(){
								public String call() throws Exception {
									return ex.exchange("dsdsd");
								}
							});
		Future<String> s2 = executor.submit(new Callable<String>(){
								public String call() throws Exception {
									return ex.exchange("dfldkkdfkjdkfjkdjfkdjfkjdf");
								}
							});
	//	s.cancel(true);
		
		//  slfkgjklfdglkdfjglkdfg
		if (s.isDone()) {
			System.err.println("Done");
		}
		try {
			String ret = s.get();
			
			System.err.println("REF: "+ret);
		} catch (CancellationException e) {
			// 
		} catch (ExecutionException e) {
			System.err.println("EXception: "+e.getCause());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		synchronized(executor) {
			executor.shutdown();
			if (!executor.isShutdown()) {
				executor.execute(()->{System.err.println("dldfkdld");});
			}
		}
		
		
	}

}

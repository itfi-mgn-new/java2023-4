package lesson25;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Timer	t = new Timer(true);
		
		TimerTask	tt = new TimerTask() {
							@Override
							public void run() {
								System.err.println("tick");
							}
						};
						
		t.schedule(tt, 1000, 2000);
		Thread.sleep(20000);
		tt.cancel();
	}

}

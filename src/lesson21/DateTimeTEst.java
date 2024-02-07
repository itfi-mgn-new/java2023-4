package lesson21;

import java.util.Calendar;
import java.util.Date;

public class DateTimeTEst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("sec_ "+System.currentTimeMillis());
		System.err.println("Nano "+System.nanoTime());
		
		Date	d = new Date(System.currentTimeMillis());
		d.getTime();
		Calendar	cal = Calendar.getInstance();
		cal.setTimeInMillis(1000);
		Calendar	cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(10000);
		
		long delta = cal2.getTimeInMillis()-cal.getTimeInMillis();
		Calendar	cal3 = Calendar.getInstance();
		cal3.setTimeInMillis(delta);
		
		
		System.err.println("CAl: "+cal.toString());
		
	}

}

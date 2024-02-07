package lesson21;

import java.util.Calendar;

public class Exercise {
	public static final String FAMILIES = "ivanov ivan ivanovich 24\n" +
										  "petrov petr petrovich 19\n" +
										  "sidorov sidor sidorovich 33";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Calendar	c = Calendar.getInstance();
		final int		year = 2024;
		int	count = 0;
		
		c.set(year, Calendar.JANUARY, 1);
		while(c.get(Calendar.YEAR) == year) {
			if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				count++;
			}
			c.add(Calendar.DAY_OF_YEAR, 1);
		}
		System.err.println("Days: "+count);
	}

}

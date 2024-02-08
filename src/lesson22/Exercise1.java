package lesson22;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Exercise1 {
	public static final String	FIOS = "ivanov i i, 12-10-1980\n" +
									"petrov p p, 03-02-1991\n" +
									"sidorov s s, 14-11-1978\n";
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String[]	human = splitString(FIOS);
		Date[]		dates = extractDates(human);
		String[]	ordered = sort(human, dates);
		String		result = join(ordered);
		
		System.err.print("result: "+result);
	}
	
	public static String[] splitString(final String source) {
		return source.split("\n");
	}
	
	public static Date[] extractDates(final String[] source) throws ParseException {
		final Date[]	result = new Date[source.length];
		final SimpleDateFormat	sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		for(int index = 0; index < result.length; index++) {
			final String[]	parts = source[index].split(",");
			
			result[index] = sdf.parse(parts[1]);
		}
		return result;
	}
	
/*	public static String[] sort(final String source[], final Date[] dates) {
		final Pair[]	pair = new Pair[source.length];
		
		for(int index = 0; index < pair.length; index++) {
			pair[index] = new Pair(source[index], dates[index]);
//			pair[index].source = source[index];
//			pair[index].date = dates[index];
		}
		
		// sort
		Arrays.sort(pair);
		
		
		final String[]	result = new String[pair.length];
		
		for (int index = 0; index < result.length; index++) {
			result[index] = pair[index].source;
		}
		return result;
	}
*/
	public static String[] sort(final String source[], final Date[] dates) {
		for (int out = source.length - 1; out >= 1; out--){  //Внешний цикл
            for (int in = 0; in < out; in++){       //Внутренний цикл
                if(dates[in].getTime() - dates[in + 1].getTime() > 0)  {              //Если порядок элементов нарушен
                	Date	d = dates[in];
                	dates[in] = dates[in+1];
                	dates[in+1] = d;
                	String	s = source[in];
                	source[in] = source[in+1];
                	source[in+1] = s;
                }
            }
        }
		return source;
	}
	
	public static String join(final String[] source) {
		final StringBuilder sb = new StringBuilder();
		
		for (String item : source) {
			sb.append('\n').append(item);
		}
		return sb.substring(1);
	}
	
	private static class Pair implements Comparable {
		String	source;
		Date 	date;

		public Pair(String source, Date date) {
			this.source = source;
			this.date = date;
		}

		@Override
		public int compareTo(Object o) {
			
			return -((Pair)o).date.compareTo(this.date);
		}
	}
}

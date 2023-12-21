package lesson14;

import java.util.Arrays;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("3+5+10="+calc("3+5+10"));	// 3+5+10=18
	}
	
	static int calc(final String source) {
		// TODO: split string by '+' and calculate sum;
		// 1:
//		final String[]	splitted = source.split("\\+");
	
//		// 2:
//		final int[]		temp = new int[splitted.length];
//		
//		for(int index = 0; index < temp.length; index++) {
//			temp[index] = Integer.valueOf(splitted[index]);
//		}
		
		// 3:
		System.err.println("Content: "+Arrays.toString(source.split("\\+")));
		int	sum = 0;
		for(String x : source.split("\\+")) {
			sum += Integer.valueOf(x);
		}
		return sum;
	}

}

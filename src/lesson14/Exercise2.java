package lesson14;

import java.util.Arrays;

public class Exercise2 {

	public static void main(String[] args) {
		System.err.println("3+5-10-4+7="+calc("3+5-10-4+7"));	// 3+5-10-4+7=1
	}
	
	static int calc(final String source) {
		// TODO: split string and calculate sum
		int	sum = 0;
		for(String x : source.split("\\+")) {
			int	sum1 = 0;
			boolean theSameFirst = true;
			for(String x1 : x.split("\\-")) {
				if (theSameFirst) {
					sum1 += Integer.valueOf(x1);
					theSameFirst = false;
				}
				else {
					sum1 -= Integer.valueOf(x1);
				}
			}
			
			sum += sum1;
		}
		return sum;
	}

}

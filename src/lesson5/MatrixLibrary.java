package lesson5;

import java.util.Arrays;

public class MatrixLibrary {
	public static void main(String[] args) {
		final int[][] m1 = new int[][] {new int[] {1,2,3}, new int[] {4,5,6}, new int[] {7,8,9}};
		final int[][] m2 = new int[][] {new int[] {10,20,30}, new int[] {40,50,60}, new int[] {70,80,90}};
		
		System.err.println("Add="+Arrays.toString(add(m1,m2)));
		System.err.println("Multiply="+Arrays.toString(mul(m1,m2)));
	}
	
	public static int[][] add(final int[][] left, final int[][] right) {
		// TODO:
	}

	public static int[][] mul(final int[][] left, final int[][] right) {
		// TODO:
	}
}

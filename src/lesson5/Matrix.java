package lesson5;

import java.util.Arrays;

public class Matrix {
	
	private int[][]		content;
	
	public Matrix() {
	}

	public Matrix(int[][] initialContent) {
		setContent(initialContent);
	}
	
	public static void main(String[] args) {
		final int[][] m1 = new int[][] {new int[] {1,2,3}, new int[] {4,5,6}, new int[] {7,8,9}};
		final int[][] m2 = new int[][] {new int[] {10,20,30}, new int[] {40,50,60}, new int[] {70,80,90}};
		
		final Matrix	mat1 = new Matrix(m1), mat2 = new Matrix(m2);
		
//		mat1.setContent(m1);
//		mat2.setContent(m2);
		
		System.err.println("Add="+mat1.add(mat2));
		System.err.println("Multiply="+mat1.mul(mat2));
		//m1 = new Matrix()..., m2, m3, m4, m5;
		// total = m1.mul(m2).add(m3.mul(m4)).add(m5);
		//m1 * m2 + m3 * 4 + m5
	}

	public Matrix add(final Matrix right) {
		// 1. null
		// 2. this.���_����� == right.���_����� && this.���_�������� == right.���_��������
		// TODO:
		/*final Matrix newMatrix =*/ return new Matrix(MatrixLibrary.add(getContent(), right.getContent()));
		
	//	newMatrix.setContent(MatrixLibrary.add(getContent(), right.getContent()));
		//return newMatrix;
	}

	public Matrix mul(final Matrix right) {
		// 1. null
		// 2. this.���_����� == right.���_��������
	}
	
	public int[][] getContent() {
		// TODO:
	}
	
	public void setContent(final int[][] content) {
		// TODO:
	}
	
	
	@Override
	public String toString() {
		return "Matrix [content=" + Arrays.deepToString(content) + "]";
	}
}

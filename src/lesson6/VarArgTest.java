package lesson6;

public class VarArgTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(/*new int[]{*/3,4,7,21,-2/*}*/);
		print(new int[]{3,4,7,21,-2});
	}
	
	public /*vararg*/ static void print(int/*[]*/... values) {
		int[] x = values;
		
	}

//	public static void print(int[] values) {
//		
//	}
	
	public static void add(String s, int... values) {
		
	}



}

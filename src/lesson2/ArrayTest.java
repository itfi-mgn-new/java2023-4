package lesson2;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int		y[], z;
		int[]	x = null, t = new int[] {10,20,30};
		
		x = t.clone();

		for (int val : t) {
			System.err.println("t="+val);
		}
		x[0] = 100;
		
		for (int val : t) {
			System.err.println("t="+val);
		}
		
		for(int index = 0; index < t.length; index++) {
			System.err.println("T["+index+"]="+t[index]);
		}
		
//		x = t;
		
		z = x.length;
		
		Object	obj = x;
		
		
	}

}

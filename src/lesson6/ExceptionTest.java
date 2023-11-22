package lesson6;

import java.io.IOException;

public class ExceptionTest {
	public static void error(int x) throws Exception, Throwable {
		switch (x) {
			case 0 : throw new NullPointerException("RTE");
			case 1 : throw new Exception("Exception");
			case 2 : throw new Throwable("Throwable", new IOException("sdsdlkj"));
			default :
				break;
		}
	}
	
	public static void nestedError(int x) throws Throwable {
		try {
			error(x);
		} catch (Exception e) {
			System.err.println("NESTED exception: "+e.getMessage());
		} finally {
			System.err.println("--- Finally ---");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Throwable	t = new Throwable("I'M HANGRY!");
		
		t.printStackTrace();
		for(int index = 0; index <= 3; index++) {
			try {
				nestedError(index);
				System.err.println("Success");
			} catch (RuntimeException e) {
				System.err.println("RTE: "+e.getMessage());
			} catch (Exception e) {
				System.err.println("Exception: "+e.getMessage());
			} catch (Throwable e) {
				System.err.println("Throwable: "+e.getMessage());
			} finally {
				System.err.println("Finally");
			}
		}
	}

}

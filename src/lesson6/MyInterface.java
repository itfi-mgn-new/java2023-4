package lesson6;

public interface MyInterface {
	/*public static final */ int x = 10;
	/*public */ void method1(int x);
	
	/*public */ static void assa() {
		System.err.println("skjdhkjsdhfkjh");
	}
	
	default void method4() {
		
		System.err.println("r0tr90t8");
	}
	
	
}

interface MyInterface2 {
	void method2(int x);
}

interface Total extends MyInterface, MyInterface2 {
	void method3(double x);
}
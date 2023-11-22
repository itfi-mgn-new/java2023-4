package lesson6;

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyInterface m = new NewClass();
		
		callMethod1(new NewInterfaceTest());
		callMethod1(new NewClass());
	}
	
	public static void callMethod1(/*InterfaceTest*/MyInterface it) {
		((NewInterfaceTest)it).method2(100);
		it.method1(200+MyInterface.x);
		MyInterface.assa();
	}

	public void method1(int x) {
		System.err.println("Method1: "+x);
	}
	
	public void method2(int x) {
		
	}
	
	public void method3(double x) {
		
	}
}

class NewClass extends InterfaceTest implements Total {
	
}

class NewInterfaceTest implements MyInterface {
	public void method1(int x) {
		System.err.println("new interface Method1: "+x);
	}
	
	public void method2(int x) {
		
	}
	
	public void method3(double x) {
		
	}
}
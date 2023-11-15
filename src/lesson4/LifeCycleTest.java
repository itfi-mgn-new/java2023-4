package lesson4;

public class LifeCycleTest {
	static final int		x = 10;		// static final primitive/String on compile time
										// ConstValue   x=10;
	static final double 	aaa = Math.random();	
	
	// public static void <clinit>() {
	// y = Math.random();
	static {
		System.err.println("Static!");
		// return - not!!!!!;
	}
	// }
	
	final int z = 30;
	final double t = Math.random();
	
	{
		System.err.println("instance");
	}
	
	// public void <init>{
	//    super();
	//    x = 10;
	//	  t = Math.random();
	// System.err.println("instance");
	public LifeCycleTest() {
		System.err.println("dlkfjlksdfjklj");
	}
	// }
	
	public LifeCycleTest(int x) {
		System.err.println("x===="+x);
	}
	
	static void staticPrint() {
		System.err.println("Static print="+/*this.*/x);
	}
	
	/*static*/ void print(/*LifeCycleTest this*/) {
		System.err.println("Print="+/*this.*/t);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("Hello world");
		LifeCycleTest	lct = new LifeCycleTest();
		System.err.println("Instance created");
		
		System.err.println("t="+lct.t);
		lct./*LifeCycleTest.*/print(/*lct*/);
		
		lct = new LifeCycleTest();
		
	}

	static {
		// sdjfjlksdjfkl
	}
	
}

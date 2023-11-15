package lesson4;

public class ChildLifeTEst extends LifeCycleTest {
	static final int		x = 100;		// static final primitive/String on compile time
	// ConstValue   x=10;
	static final double 	y = 10*Math.random();	

	// public static void <clinit>() {
	// y = Math.random();
	static {
		System.err.println("Child Static!");
		// return - not!!!!!;
	}
	// }	
	
	final int z = 100;
	final double t = 10*Math.random();
	int www;
	
	public ChildLifeTEst() {
		// super();
		super(123);
		System.err.println("djklsjkjfjflkjsdfkjslkdfjlskdjfksdjfsjlk");
	}
	
	static void staticPrint() {
		System.err.println("Child static print="+/*this.*/x);
	}
	
	/*static*/ void print(/*LifeCycleTest this*/) {
		super.print();
		System.err.println("Child Print="+/*this.*/t);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.err.println("Hello world static");
		ChildLifeTEst clt = new ChildLifeTEst();
		int aaa = 20;
		
		System.err.println("x="+/*ChildLifeTEst.*/aaa);
		System.err.println("z="+((LifeCycleTest)clt).z);
		
		clt./*ChildLifeTEst.*/staticPrint();
		clt.print();
		LifeCycleTest.staticPrint();
		((LifeCycleTest)clt).print();
		
		LifeCycleTest l = clt;
		l.print();
		
		System.err.println(z(3,5));
	}

	//		call type				this		VMT
	//		invokestatic			-			-
	//		invokevirtual			+			+
	//		invokespecial			+			-
	//		invokeinterface			+			+
	//
	
	static int z(int x, int/*[]*/ y) {//	1-x,1-y,1-a = 3;
		int a = 10;
	//	y[0] = 10;
		return a * (x + y);//2-		// 5 ue
	}
}

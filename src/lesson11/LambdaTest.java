package lesson11;

import java.lang.reflect.Method;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaTest	owner = new LambdaTest();
		
		call(new OuterClass());
		call(owner.new InnerClass());
		call(new MyInterface() {
			@Override
			public int calc(int x, int y) {
				return x * y;
			}
		});
		MyInterface mi = (x,y)->x / y; // ::lambda$0; 
		
		Class cl = mi.getClass();
		
		System.err.println("Name="+cl.getName());
		
		Class ownerCl = owner.getClass();
		
		for (Method m : ownerCl.getDeclaredMethods()) {
			System.err.println("Method: "+m);
		}
		
		call(mi);
		
		mi = LambdaTest::assa;
		call(mi);
		
	}

	/*
	 * private static labmda$0(int x, int y) {
	 * 		return x / y;
	 * }
	 */
	
	static void call(final MyInterface mi) {
		System.err.println("Calc="+mi.calc(3,5));
	}
	
	static int assa(int x, int y) {
		return x % y;
	}
	
	class InnerClass implements MyInterface {

		@Override
		public int calc(int x, int y) {
			return x - y;
		}
		
	}
	
}

@FunctionalInterface
interface MyInterface {
	int calc(int x, int y);
	default int x() {return 0;};
}

class OuterClass implements MyInterface {

	@Override
	public int calc(int x, int y) {
		return x + y;
	}
	
}
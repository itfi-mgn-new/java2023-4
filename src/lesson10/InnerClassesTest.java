package lesson10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class InnerClassesTest {
	static int x = 10;
	
	int y = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClassesTest owner = new InnerClassesTest(); 
		NestedClass	n = /*owner.*/new NestedClass();
		
		Class	cl = NestedClass.class;
		
		for(Constructor c : cl.getDeclaredConstructors()) {
			System.err.println("C: "+c);
		}
		for(Field f : cl.getDeclaredFields()) {
			System.err.println("F: "+f);
		}
		
	}

	void call() {
		/*this.*/new NestedClass();
	}
	
	private static class NestedClass {
		static int t = 10;
		int z = 30;
		// SpecialClassesTest this$0;
		
		static {
			
		}
		
//		public NestedClass(SpecialClassesTest zzzz) {
//			this$0 = zzzz;
//		}
		
		void print() {
			System.err.println("x+y+z="+(
					/*SpecialClassesTest.*/x 
//					+ /*this$0.*/ y 
					+ /*this.*/z));
		}
	}
}

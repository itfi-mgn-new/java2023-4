package lesson10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class AnonymousClassesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyInterface	mi = new MyAnon();
		
		mi.print();
		
		/*final */ int x = 10;
		
		mi = new MyInterface() {
			int aaa = 20;
			/* private int val$x;
			 * private AnonymousClassesTest$1(int val) {
			 * 	val$x = val;
			 *  System.err.println("assa");
			 * }
			 */
			{
				System.err.println("assa");
			}
			@Override
			public void print() {
				System.err.println("sldfjklsjdfkljsdf = "+/*val$x*/x);
			}
		};
		//x = x -1;
		
		Class	cl = mi.getClass();
		for(Constructor c : cl.getDeclaredConstructors()) {
			System.err.println("C: "+c);
		}		
		for(Field f : cl.getDeclaredFields()) {
			System.err.println("F: "+f);
		}
		System.err.println("Name: "+cl.getName());
		
		
		mi.print();
		
		mi = new MyInterface() {
			@Override
			public void print() {
				System.err.println("lk = "+x);
			}
		};
		
		Object z = new Object() {
			{System.err.println("INside ");}
		};
		
		class Local {
			
		}
	}
}

class MyAnon implements MyInterface {

	@Override
	public void print() {
		System.err.println("ppopopopopo");
	}
}
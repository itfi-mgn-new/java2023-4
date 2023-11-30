package lesson9;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest {
	public static int x = 100;
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
		// TODO Auto-generated method stub
//		test(new int[] {2,3,4});
//		test("vassya");
//		test(new ReflectionTest());
//		test(new NewClass());
		
		Class	z = ReflectionTest.class;
		Class	z2 = new ReflectionTest().getClass();
		
		testArray(new int[] {4,5,6});
	}

	static void testArray(final Object obj) {
		final Class		cl = obj.getClass();

		System.err.println("LEngth: "+Array.getLength(obj));
		System.err.println("Get[0]: "+Array.get(obj,0));
		
		final long[]	array = (long[])Array.newInstance(long.class, 20);
	}
	
	static void test(final Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
		final Class		cl = obj.getClass();
		
		System.err.println("Name="+cl.getCanonicalName());
		System.err.println("Is array="+cl.isArray());
//		System.err.println("Array content="+cl.getComponentType());
//		
//		final Class 	clx = cl.getComponentType();
//	
//		System.err.println("COntent name="+clx.getCanonicalName());
//		System.err.println("Is primitive="+clx.isPrimitive());

		Method[] m = cl.getMethods();
		for(Method mm : m) {
			System.err.println("MEthod name: "+mm.getName());
		}
//		Method	len = cl.getMethod("length");
//		System.err.println("Length name: "+len.getName());
//		System.err.println("Param count: "+len.getParameterCount());
//		System.err.println("REsult: "+len.getReturnType());
//		try {
//			System.err.println("CALL: "+len.invoke(obj));
//		} catch (InvocationTargetException exc ) {
//			System.err.println("Problem ....");
//		}
		
		Field[]	f = cl.getFields();
		for(Field ff : f) {
			System.err.println("Field name: "+ff.getName());
		}
		System.err.println("Superclass: "+cl.getSuperclass());
		Field	fld = cl.getSuperclass().getDeclaredField("x");
		System.err.println("Field type: "+fld.getType());
		fld.setAccessible(true);
		System.err.println("Field value: "+fld.get(obj));
		fld.set(obj, 200);
		
		System.err.println("New field value: "+x);
		
	}
}

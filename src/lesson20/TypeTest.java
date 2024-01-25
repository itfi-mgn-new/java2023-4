package lesson20;

import java.lang.reflect.Field;

public class TypeTest<T extends java.lang.Number, X> {

	public final T	value;
	public final X	value2;
	
	public TypeTest(T initial, X another) {
		this.value = initial;
		this.value2 = another;
	}
	
	public T get() {
		return value;
	}
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		// TODO Auto-generated method stub
//		TypeTest<String>	tts = new TypeTest("vassya");
		TypeTest<Integer,Integer>	tti = new TypeTest<>(100,100);
//		String	tts1 = tts.get();
		int		tti1 = tti.get();
		
		Class	cl = tti.getClass();
		Field	f = cl.getField("value");
		
		System.err.println("Type: "+f.getType());
	}

}

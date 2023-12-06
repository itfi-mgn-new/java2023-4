package lesson10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyEnum	e = MyEnum.first;
		Enum ee = e;
		
		System.err.println("E? "+(e == MyEnum.first));
		
		Class	cl = e.getClass();
		for(Constructor c : cl.getDeclaredConstructors()) {
			System.err.println("C: "+c);
		}	
		System.err.println("Super: "+cl.getSuperclass());
		for(Field f : cl.getDeclaredFields()) {
			System.err.println("F: "+f);
		}
		System.err.println("Name: "+e.name());
		System.err.println("Ordinal: "+e.ordinal());
		System.err.println("Values: "+Arrays.toString(MyEnum.values()));
		
		System.err.println("Values(2): "+Arrays.toString(cl.getEnumConstants()));

		Class in = EnumTest.class;
		
		for(Method m : in.getDeclaredMethods()) {
			System.err.println("Method: "+m);
		}
		
		switch (e/*.ordinal()*/) {
			case first/*.ordinal()*/:
				break;
			case second/*.ordinal()*/:
				break;
			case third/*.ordinal()*/:
				break;
			default:
				throw new UnsupportedOperationException("Item ["+e+"] is not supported yet");
		}
	}
}


/* final class */ enum MyEnum /* extends java.lang.Enum */ {
	/*public static final */ first("family") /*= new MyEnum("first", 0, "family") */ ,		
	/*public static final */ second("name") /*= new MyEnum("second", 1, "name") */ ,
	/*public static final */ third("patroname") /*= new MyEnum("third", 2, "patroname") */;
	
	private final String comment;
	
	private MyEnum(/*final String name, final int ordinal,*/ final String comment) {
		/*super(name, ordinal);*/
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}
}
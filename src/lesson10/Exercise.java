package lesson10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Value(100)
public class Exercise {
	@Value(30) int z;
	
	@Value(20) public static void main(String[] args) {
		int sum = 0;
		Class	cl = Exercise.class;
		Value v = (Value)cl.getAnnotation(Value.class);
		if (v != null) {
			sum += v.value();
		}
		for (Method m : cl.getDeclaredMethods()) {
			v = m.getAnnotation(Value.class);
			if (v != null) {
				sum += v.value();
			}
		}
		for (Field f : cl.getDeclaredFields()) {
			v = f.getAnnotation(Value.class);
			if (v != null) {
				sum += v.value();
			}
		}
		System.err.println("Sum="+sum);
	}
}

package lesson9;

import java.lang.reflect.Field;

public class Exercise {
	public static int	x = 10;
	
	public static int[]	z = new int[] {4,5,6};
	
	public int y = 20;

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		System.err.println("Sum="+calcSum(new Exercise()));
	}

	static int calcSum(final Object oj) throws IllegalArgumentException, IllegalAccessException {
		// Найти в экземпляре объекта все целочисленные поля и подсчитать сумму их значений
		final Class	cl = oj.getClass();
		int	sum = 0;
		
		for(Field f : cl.getFields()) {
			if (f.getType() == int.class) {
				sum += f.getInt(oj);
			}
		}
		return sum;
	}
	
}

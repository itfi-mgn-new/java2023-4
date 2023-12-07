package lesson11;

public class Exercise {
	public interface CalcInterface {
		int calculate(int x, int y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise owner = new Exercise();
		System.err.println("Val="+calculate(new ZZZ()));	// Обычный класс
		System.err.println("Val="+calculate(owner.new TTT()));	// Вложенный класс
		System.err.println("Val="+calculate(new CalcInterface() {

			@Override
			public int calculate(int x, int y) {

				return x * y;
			}}));  // Анонимный класс
		System.err.println("Val="+calculate((x,y)->x/y));  // Лямбда-выражение
	}

	public static int calculate(final CalcInterface calc) {
		return calc.calculate(100,200);
	}

	class TTT implements CalcInterface {

		@Override
		public int calculate(int x, int y) {
			
			return x - y;
		}
		
	}
}


class ZZZ implements Exercise.CalcInterface {

	@Override
	public int calculate(int x, int y) {
		
		return x + y;
	}
	
}


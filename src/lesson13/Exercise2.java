package lesson13;

public class Exercise2 {
	static final String[] ANSWER = {"ноль", "один"};
	static final String[] HUNDREDS = {"", " сто", " двести"};
	static final String[] TEENS = {" десять", " одиннадцать", " двенадцать"};
	static final String[] TENS = {"", "", " двадцать", " тридцать"};
	static final String[] UNITS = {"", " один", " два", " три"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(toWords(123));	// сто двадцать семь
	}

	static String toWords(int value) {
		// TODO:
//		switch (value) {
//			case 0 : return "ноль";
//			case 1 : return "адын";
//			// .....
//			case 999 : return "дквятьсот девяность девять";
//			default :
//				throw new IllegalArgumentException("Value ["+value+"] out of range 0..999");
//		}
//		if (value < 0 || value >= 1000) {
//			throw new IllegalArgumentException("Value ["+value+"] out of range 0..999");
//		}
//		else {
//			return ANSWER[value];
//		}
		if (value < 0 || value >= 1000) {
			throw new IllegalArgumentException("Value ["+value+"] out of range 0..999");
		}
		else if (value == 0) {
			return "ноль";
		}
		else {
			int handreds = value / 100;
			value %= 100;
			int tens = value / 10;
			value %= 10;
			
			StringBuilder	sb = new StringBuilder();
			sb.append(HUNDREDS[handreds]);
			
			if (tens == 1) {
				sb.append(TEENS[value]);
			}
			else {
				sb.append(TENS[tens]);
				sb.append(UNITS[value]);
			}
			return sb.substring(1);
		}
		
	}
}

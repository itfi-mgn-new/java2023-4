package lesson13;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(toCaps("ivanov ivan ivanovich")); // Ivanov Ivan Ivanovich
	}
	
	static String toCaps(final String source) {
		// TODO:
//		final StringBuilder sb = new StringBuilder();
//		
//		for (String item : source.split(" ")) {
//			sb.append(' ')
//				.append(Character.toUpperCase(item.charAt(0)))
//				.append(item.substring(1).toLowerCase());
//		}
//		return sb.substring(1);
		final char[]	result = new char[source.length()];
		int				state = 0;
		
		for(int index = 0; index < result.length; index++) {
			final char	symbol = source.charAt(index);
			
			switch (state) {
				case 0 :
					result[index] = Character.toUpperCase(symbol);
					state = 1;
					break;
				case 1 :
					if (symbol != ' ') {
						result[index] = Character.toLowerCase(symbol);
					}
					else {
						state = 2;
						result[index] = ' ';
					}
					break;
				case 2 :
					if (symbol == ' ') {
						result[index] = ' ';
					}
					else {
						state = 0;
						index--;
					}
					break;
			}
		}
		return new String(result);
	}
}

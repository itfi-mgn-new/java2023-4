package lesson12;

public class Exercise {

	public static void main(String[] args) {
		String	s = "abcdefg";
		// TODO: "AbCdEfG";
//		StringBuilder r = new StringBuilder();
//		for(int index = 0; index < s.length(); index++) {
//			if (index % 2 == 0) { 
//				r.append(Character.toUpperCase(s.charAt(index)));
//			}
//			else {
//				r.append(Character.toLowerCase(s.charAt(index)));
//			}
//		}
		char[]	r = new char[s.length()];
		for(int index = 0; index < r.length; index++) {
			if (index % 2 == 0) { 
				r[index] = Character.toUpperCase(s.charAt(index));
			}
			else {
				r[index] = Character.toLowerCase(s.charAt(index));
			}
			
		}
		System.err.println("R="+new String(r));
		
	}

}

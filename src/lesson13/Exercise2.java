package lesson13;

public class Exercise2 {
	static final String[] ANSWER = {"����", "����"};
	static final String[] HUNDREDS = {"", " ���", " ������"};
	static final String[] TEENS = {" ������", " �����������", " ����������"};
	static final String[] TENS = {"", "", " ��������", " ��������"};
	static final String[] UNITS = {"", " ����", " ���", " ���"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println(toWords(123));	// ��� �������� ����
	}

	static String toWords(int value) {
		// TODO:
//		switch (value) {
//			case 0 : return "����";
//			case 1 : return "����";
//			// .....
//			case 999 : return "��������� ��������� ������";
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
			return "����";
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

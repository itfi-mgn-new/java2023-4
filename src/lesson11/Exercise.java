package lesson11;

public class Exercise {
	public interface CalcInterface {
		int calculate(int x, int y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("Val="+calculate(...));	// ������� �����
		System.err.println("Val="+calculate(...));	// ��������� �����
		System.err.println("Val="+calculate(...));  // ��������� �����
		System.err.println("Val="+calculate(...));  // ������-���������
	}

	public static int calculate(final CalcInterface calc) {
		return calc.calculate(100,200);
	}
}



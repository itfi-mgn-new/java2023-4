package lesson7;

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	void go2Wall(final Robot r) {
		while (!r.isWall()) {	// ������ �� ������
			r.forward();
		}
	}
	
	void toLeftBottom(final Robot r) {
		while (r.getRotationAngle() != 270) {	// ������ �� ��!
			r.left();
		}
//		int x0 = r.getX();
//		int y0 = r.getY();
		go2Wall(r);
//		while (!r.isWall()) {	// ������ (�� ��) �� ������
//			r.forward();
//		}
		r.right();	// ��������� �� �����
		go2Wall(r);
//		while (!r.isWall()) {	// ������ (�� �����) �� ������
//			r.forward();
//		}
	}

	int calcSquare(final Robot r) {		
	}
	
	void mineGold(final Robot r) {
	}
}

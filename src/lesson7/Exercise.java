package lesson7;

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	void go2Wall(final Robot r) {
		while (!r.isWall()) {	// Вперед до стенки
			r.forward();
		}
	}
	
	void toLeftBottom(final Robot r) {
		while (r.getRotationAngle() != 270) {	// Мордой на юг!
			r.left();
		}
//		int x0 = r.getX();
//		int y0 = r.getY();
		go2Wall(r);
//		while (!r.isWall()) {	// Вперед (на юг) до стенки
//			r.forward();
//		}
		r.right();	// Повернуть на запад
		go2Wall(r);
//		while (!r.isWall()) {	// Вперед (на запад) до стенки
//			r.forward();
//		}
	}

	int calcSquare(final Robot r) {		
	}
	
	void mineGold(final Robot r) {
	}
}

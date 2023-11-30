package lesson7;

import lesson8.FakeRobot;

public class Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Exercise	ex = new Exercise();
		
		ex.toLeftBottom(new FakeRobot(7,9));
		
		
//		System.err.println("Square="+ex.calcSquare(new FakeRobot(7,9)));
//		ex.mineGold(new FakeRobot(7,9,0,0,true));
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

//	int calcSquare(final Robot r) {		
//	}
//	
//	void mineGold(final Robot r) {
//	}
}

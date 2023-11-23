package lesson7;

public interface Robot {
	int getX();
	int getY();
	int getRotationAngle();	// 0, 90, 180, 270
	Robot forward();
	Robot left();
	Robot right();
	boolean isWall();
	boolean isCargo();
	Robot take(Object cargo);
	Robot drop();
}

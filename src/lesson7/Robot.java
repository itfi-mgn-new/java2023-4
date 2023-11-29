package lesson7;

public interface Robot {
	int getX();
	int getY();
	int getRotationAngle();	// 0 east, 90 north, 180 west, 270 south
	Robot forward();
	Robot left();
	Robot right();
	boolean isWall();	// Брюс Эккель. Философия Java.
	boolean isCargo();
	Robot take(Object cargo);
	Robot drop();
}

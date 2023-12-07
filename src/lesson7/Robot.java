package lesson7;

public interface Robot {
	int getX();
	int getY();
	Direction getRotationAngle();
	Robot forward();
	Robot left();
	Robot right();
	boolean isWall();	// Брюс Эккель. Философия Java.
	boolean isCargo();
	Robot take(Object cargo);
	Robot drop();
}

package lesson7;

public interface Robot {
	int getX();
	int getY();
	Direction getRotationAngle();
	Robot forward();
	Robot left();
	Robot right();
	boolean isWall();	// ���� ������. ��������� Java.
	boolean isCargo();
	Robot take(Object cargo);
	Robot drop();
}

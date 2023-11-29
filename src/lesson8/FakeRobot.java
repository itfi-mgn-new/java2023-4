package lesson8;

import lesson7.Robot;

public class FakeRobot implements Robot {
	private final int		roomWidth;
	private final int		roomHeight;
	private final boolean	cargoPresents;
	private int				robotX;
	private int				robotY;
	private int				robotAngle;
	private int				cargoX = Integer.MIN_VALUE;
	private int				cargoY = Integer.MIN_VALUE;
	private boolean			takeCargo = false;
	private Object			cargo = null;
	
	public FakeRobot(final int roomWidth, final int roomHeight) {
		this(roomWidth, roomHeight, getRandomValue(0, roomWidth), getRandomValue(0, roomHeight));
	}

	public FakeRobot(final int roomWidth, final int roomHeight, final int robotX, final int robotY) {
		this(roomWidth, roomHeight, robotX, robotY, false);
	}

	public FakeRobot(final int roomWidth, final int roomHeight, final int robotX, final int robotY, final boolean placeCargo) {
		if (roomWidth <= 1) {
			throw new IllegalArgumentException("Room width ["+roomWidth+"] must be greater than 1");
		}
		else if (roomHeight <= 1) {
			throw new IllegalArgumentException("Room height ["+roomHeight+"] must be greater than 1");
		}
		else if (robotX < 0 || robotX >= roomWidth) {
			throw new IllegalArgumentException("Robot X coordinate ["+robotX+"] out of range 0.."+(roomWidth-1));
		}
		else if (robotY < 0 || robotY >= roomHeight) {
			throw new IllegalArgumentException("Robot Y coordinate ["+robotY+"] out of range 0.."+(roomHeight-1));
		}
		else {
			this.roomWidth = roomWidth;
			this.roomHeight = roomHeight;
			this.robotX = robotX;
			this.robotY = robotY;
			this.robotAngle = (getRandomValue(0, 360) / 90) * 90;
			this.cargoPresents = placeCargo;
			if (placeCargo) {
				for(;;) {
					final int	x = getRandomValue(0, roomWidth);
					final int	y = getRandomValue(0, roomHeight);
					
					if (robotX != x && robotY != y) {
						this.cargoX = x;
						this.cargoY = y;
						break;
					}
				}
			}
		}
	}
	
	@Override
	public int getX() {
		return robotX;
	}

	@Override
	public int getY() {
		return robotY;
	}

	@Override
	public int getRotationAngle() {
		return robotAngle;
	}

	@Override
	public Robot forward() {
		if (isWall()) {
			throw new IllegalStateException("Attempt to run thru wall at location ("+getX()+","+getY()+")");  
		}
		else if (isCargo()) {
			throw new IllegalStateException("Attempt to press cargo at location ("+getX()+","+getY()+")");  
		}
		else {
			switch (getRotationAngle()) {
				case 0		:
					robotY++;
					break;
				case 90 	:
					robotX++;
					break;
				case 180 	:
					robotY--;
					break;
				case 270 	:
					robotX--;
					break;
				default :
					throw new UnsupportedOperationException("Robot rotation angle ["+getRotationAngle()+"] is not supported yet");
			}
			return this;
		}
	}

	@Override
	public Robot left() {
		if (robotAngle == 270) {
			robotAngle = 0;
		}
		else {
			robotAngle += 90;
		}
		return this;
	}

	@Override
	public Robot right() {
		if (robotAngle == 0) {
			robotAngle = 270;
		}
		else {
			robotAngle -= 90;
		}
		return this;
	}

	@Override
	public boolean isWall() {
		if (getBeforeX() < 0 || getBeforeX() >= roomWidth || getBeforeY() < 0 || getBeforeY() >= roomHeight) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isCargo() {
		if (cargoPresents) {
			return getBeforeX() == cargoX && getBeforeY() == cargoY;
		}
		else {
			return false;
		}
	}

	@Override
	public Robot take(final Object cargo) {
		if (takeCargo) {
			throw new IllegalStateException("Robot takes cargo already");
		}
		else if (!isCargo()) {
			throw new IllegalStateException("No cargo to take at location ("+getBeforeX()+","+getBeforeY()+")");
		}
		else {
			takeCargo = true;
			this.cargo = cargo;
			return this;
		}
	}

	@Override
	public Robot drop() {
		if (takeCargo) {
			throw new IllegalStateException("Robot didn't take cargo to drop");
		}
		else if (isWall()) {
			throw new IllegalStateException("There is wall at location ("+getBeforeX()+","+getBeforeY()+"). Drop cargo failed");
		}
		else {
			takeCargo = false;
			this.cargo = null;
			this.cargoX = getBeforeX();
			this.cargoY = getBeforeY();
			return this;
		}
	}

	private int getBeforeX() {
		switch (robotAngle) {
			case 0		: return getX() + 1;
			case 90 	: return getX();
			case 180 	: return getX() - 1;
			case 270 	: return getX();
			default :
				throw new UnsupportedOperationException("Robot rotation angle ["+robotAngle+"] is not supported yet");
		}
	}

	private int getBeforeY() {
		switch (robotAngle) {
			case 0		: return getY();
			case 90 	: return getY() + 1;
			case 180 	: return getY();
			case 270 	: return getY() - 1;
			default :
				throw new UnsupportedOperationException("Robot rotation angle ["+robotAngle+"] is not supported yet");
		}
	}
	
	private static int getRandomValue(final int loWater, final int hiWater) {
		return (int) (loWater + Math.random() * (hiWater - loWater));
	}
}

package lesson8;

import lesson7.Direction;
import lesson7.Robot;

public class FakeRobot implements Robot {
	private final int		roomLength;
	private final int		roomWidth;
	private final boolean	cargoPresents;
	private int				robotX;
	private int				robotY;
	private Direction		robotAngle;
	private int				cargoX = Integer.MIN_VALUE;
	private int				cargoY = Integer.MIN_VALUE;
	private boolean			takeCargo = false;
	private Object			cargo = null;
	
	public FakeRobot(final int roomLength, final int roomWidth) {
		this(roomLength, roomWidth, getRandomValue(0, roomLength), getRandomValue(0, roomWidth));
	}

	public FakeRobot(final int roomLength, final int roomWidth, final int robotX, final int robotY) {
		this(roomLength, roomWidth, robotX, robotY, false);
	}

	public FakeRobot(final int roomLength, final int roomWidth, final int robotX, final int robotY, final boolean placeCargo) {
		if (roomLength <= 1) {
			throw new IllegalArgumentException("Room length ["+roomLength+"] must be greater than 1");
		}
		else if (roomWidth <= 1) {
			throw new IllegalArgumentException("Room width ["+roomWidth+"] must be greater than 1");
		}
		else if (robotX < 0 || robotX >= roomLength) {
			throw new IllegalArgumentException("Robot X coordinate ["+robotX+"] out of range 0.."+(roomLength-1));
		}
		else if (robotY < 0 || robotY >= roomWidth) {
			throw new IllegalArgumentException("Robot Y coordinate ["+robotY+"] out of range 0.."+(roomWidth-1));
		}
		else {
			this.roomLength = roomLength;
			this.roomWidth = roomWidth;
			this.robotX = robotX;
			this.robotY = robotY;
			this.robotAngle = Direction.values()[getRandomValue(0, 4)];
			this.cargoPresents = placeCargo;
			if (placeCargo) {
				for(;;) {
					final int	x = getRandomValue(0, roomLength);
					final int	y = getRandomValue(0, roomWidth);
					
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
	public Direction getRotationAngle() {
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
				case EAST	:
					robotX++;
					break;
				case NORTH 	:
					robotY++;
					break;
				case WEST 	:
					robotX--;
					break;
				case SOUTH 	:
					robotY--;
					break;
				default :
					throw new UnsupportedOperationException("Robot rotation angle ["+getRotationAngle()+"] is not supported yet");
			}
			return this;
		}
	}

	@Override
	public Robot left() {
		switch (getRotationAngle()) {
			case EAST:
				robotAngle = Direction.NORTH;
				break;
			case NORTH:
				robotAngle = Direction.WEST;
				break;
			case SOUTH:
				robotAngle = Direction.EAST;
				break;
			case WEST:
				robotAngle = Direction.SOUTH;
				break;
			default:
				throw new UnsupportedOperationException("Direction ["+getRotationAngle()+"] is not supported yet");
		}
		return this;
	}

	@Override
	public Robot right() {
		switch (getRotationAngle()) {
			case EAST:
				robotAngle = Direction.SOUTH;
				break;
			case NORTH:
				robotAngle = Direction.EAST;
				break;
			case SOUTH:
				robotAngle = Direction.WEST;
				break;
			case WEST:
				robotAngle = Direction.NORTH;
				break;
			default:
				throw new UnsupportedOperationException("Direction ["+getRotationAngle()+"] is not supported yet");
		}
		return this;
	}

	@Override
	public boolean isWall() {
		if (getBeforeX() < 0 || getBeforeX() >= roomLength || getBeforeY() < 0 || getBeforeY() >= roomWidth) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isCargo() {
		if (cargoPresents && !takeCargo) {
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
		if (!takeCargo) {
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
		switch (getRotationAngle()) {
			case EAST	: return getX() + 1;
			case NORTH 	: return getX();
			case WEST 	: return getX() - 1;
			case SOUTH 	: return getX();
			default :
				throw new UnsupportedOperationException("Robot rotation angle ["+robotAngle+"] is not supported yet");
		}
	}

	private int getBeforeY() {
		switch (robotAngle) {
			case EAST	: return getY();
			case NORTH 	: return getY() + 1;
			case WEST 	: return getY();
			case SOUTH 	: return getY() - 1;
			default :
				throw new UnsupportedOperationException("Robot rotation angle ["+robotAngle+"] is not supported yet");
		}
	}
	
	private static int getRandomValue(final int loWater, final int hiWater) {
		return (int) (loWater + Math.random() * (hiWater - loWater));
	}
}

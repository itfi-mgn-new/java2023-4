package lesson37;

/**
 * <p>This class is a simle calculator. It implements four basic arithmetic actions</p>
 * @author student
 * @since 0.0.1
 */
public class CLassToTest {
	/**
	 * <p>This method adds it's arguments</p>
	 * @param x value to add
	 * @param y value to add
	 * @return sum of the arguments
	 */
	public int add(int x, int y) {
		return x + y;
	}
	
	public int sub(int x, int y) {
		return x - y;
	}
	
	public int mul(int x, int y) {
		return x * y;
	}
	
	/**
	 * <p>fkgfjkldgjkfds {@linkplain CLassToTestTest test class}</p>
	 * @param x dfdf
	 * @param y dfdf
	 * @return dfdfdf
	 * @throws IllegalArgumentException when divizor == 0
	 */
	public int div(int x, int y) {
		if (y == 0) {
			throw new IllegalArgumentException("Y == 0!");
		}
		else {
			return x / y;
		}
	}
}

package lesson37;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CLassToTestTest {
	@BeforeClass
	public static void start() {
		System.err.println("Before class");
	}

	@Before
	public void prepare() {
		System.err.println("Before");
	}
	
	@Test
	public void test1() {
		final CLassToTest ctt = new CLassToTest();
		
		Assert.assertEquals(8, ctt.add(3,5));
		Assert.assertEquals(-2, ctt.sub(3,5));
		Assert.assertEquals(15, ctt.mul(3,5));
		Assert.assertEquals(0, ctt.div(3,5));
		
		try {ctt.div(3,0);
			Assert.fail("Mandatory exception was not detected (divizor == 0)");
		} catch (IllegalArgumentException exc) {
		}
	}

	@After
	public void unprepare() {
		System.err.println("After");
	}
	
	@AfterClass
	public static void end() {
		System.err.println("After class");
	}
	
	
}

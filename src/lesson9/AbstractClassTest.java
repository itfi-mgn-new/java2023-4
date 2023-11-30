package lesson9;

public abstract class AbstractClassTest {
	private static int x = 300;
	
	public void print() {
		System.err.println("Name="+name());
	}
	
	public abstract String name();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractClassTest	act = new NewClass();
	}

	
}


class NewClass extends AbstractClassTest {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "vassya";
	}
	
}
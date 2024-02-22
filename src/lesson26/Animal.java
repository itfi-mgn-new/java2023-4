package lesson26;

public abstract class Animal {
	public int weight;
	
	public Animal (int weight) {
		
	}
	
	public void eat() {
		
	}
	
	public String getName() {
		return null;
	}
	
	public abstract void sound();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class VoicedAnimal extends Animal implements Info, Info2{
		public VoicedAnimal(int weight) {
			super(weight);
		}
		
		
		@Override
		public void sound() {
			// TODO Auto-generated method stub
			
		}

//		@Override
//		public String getName() {
//			// TODO Auto-generated method stub
//			return null;
//		}
		
	}
	
	
	public static interface Info {
		String getName();
	}

	public static interface Info2 {
		String getName();
	}
}

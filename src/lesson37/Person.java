package lesson37;

public class Person {
	private final String family;
	private final String name;
	private final String patroname;
	private final int age;
	
	public Person(final String family, final String name, final String patroname, final int age) throws IllegalArgumentException  {
		if (family == null || family.isEmpty()) {
			throw new IllegalArgumentException("Family can't be null or empty");
		}
		else if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name can't be null or empty");
		}
		else if (patroname == null || patroname.isEmpty()) {
			throw new IllegalArgumentException("Patroname can't be null or empty");
		}
		else if (age <= 0) {
			throw new IllegalArgumentException("Age ["+age+"] must be greater than 0");
			
		}
		else {
			this.family = family;
			this.name = name;
			this.patroname = patroname;
			this.age = age;
		}
	}

	public String getFamily() {
		return family;
	}

	public String getName() {
		return name;
	}

	public String getPatroname() {
		return patroname;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [family=" + family + ", name=" + name + ", patroname=" + patroname + ", age=" + age + "]";
	}
}

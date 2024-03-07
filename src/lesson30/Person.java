package lesson30;

public class Person {
	public String	family;
	public String	name;
	public String	patroname;
	public int 		age;
	public Person(String family, String name, String patroname, int age) {
		this.family = family;
		this.name = name;
		this.patroname = patroname;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [family=" + family + ", name=" + name + ", patroname=" + patroname + ", age=" + age + "]";
	}
	
	
}

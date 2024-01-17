package lesson17;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1510619019333119661L;

	public String	family;
	public String	name;
	public String	patroname;
	public int		age;
	public Dept		dept;
//	public transient Object	x = new Object();
	public Object	x = null;

	public Person(String family, String name, String patroname, int age, Dept dept) {
		this.family = family;
		this.name = name;
		this.patroname = patroname;
		this.age = age;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Person [family=" + family + ", name=" + name + ", patroname=" + patroname + ", age=" + age + ", dept=" + dept + "]";
	}
}

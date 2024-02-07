package lesson21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTEst {
	public static void main(String[] args) {
		Pattern	p = Pattern.compile("\\s+(\\w*)\\s+(\\w*)\\s+");
	
		Matcher	m = p.matcher("vassya     pupkin vassya1 pupkin1 kdjfkdjf dd");
	
		System.err.println("Find: "+m.find());
		System.err.println("Group: "+m.group(1)+" "+m.group(2));
		System.err.println("Find: "+m.find());
		System.err.println("Group: "+m.group(1));
		System.err.println("Find: "+m.find());
	}
}

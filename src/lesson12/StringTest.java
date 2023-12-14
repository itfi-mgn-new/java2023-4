package lesson12;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String	z = "vassya";
		
		System.err.println("Length: "+z.length());
		System.err.println("HashCode: "+z.hashCode());
		System.err.println("Equals: "+z.equals(null));

		System.err.println("Equals [2]: "+(z == "vassya"));	// Erroneous comparison!!!
		
		System.err.println("Equals: "+z.equalsIgnoreCase("vAsSyA"));
		System.err.println("Compare to: "+z.compareTo("petya"));
		System.err.println("Compare to: "+z.compareToIgnoreCase("petya"));
		
		System.err.println("Starts with: "+z.startsWith("vas"));
		System.err.println("Ends with: "+z.endsWith("sss"));
		
		switch(z/*.hashCode()*/) {
			case "vassya"/*.hashCode()*/ :
				// if (z.equals("vassya")) {
				System.err.println("1");
				// }
				break;
			case "petya"/*.hashCode()*/ :
				System.err.println("2");
				break;
			default :
				System.err.println("ELSE");
		}

		System.err.println("Char[0] = <"+z.charAt(2)+">");
		System.err.println("Contains ? "+z.contains("ss"));
		System.err.println("Index: "+z.indexOf("a"));
		System.err.println("Last index: "+z.lastIndexOf("a"));
		System.err.println("Index: "+z.indexOf('a'));
		System.err.println("Last index: "+z.lastIndexOf('a'));
		System.err.println("Index after: "+z.indexOf("a", 2));
		
		System.err.println("substring(2) = "+z.substring(2));
		System.err.println("substring(2) = <"+z.substring(2,4)+">");
		
		System.err.println("replace = "+z.replace("ss","SS"));
		System.err.println("replace = "+z.replace('s','S'));
		System.err.println("replace = "+z.replace('s','S'));
//		System.err.println(/*new StringBuilder().append("replace = ").append(z.replace('s','S')).toString()/*);

		System.err.println("split = "+Arrays.toString(z.split("a")));
	
		char[]	content;
		System.err.println("Content = "+Arrays.toString(content = z.toCharArray()));
		
		content[2]++;
		
		System.err.println("result = "+new String(content));
		
		
		String	result = "";
		
		for(int index = 0; index < 10; index++) {
			result += ","+index;
		}
		System.err.println("REsult: "+result);
		
		
		StringBuilder	sb = new StringBuilder();
		
		for(int index = 0; index < 10; index++) {
			sb.append(",").append(index);
		}
		System.err.println("REsult: "+sb.toString());
		
	}

}

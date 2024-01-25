package lesson20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int	x = 10;
		List<String>	list = new LinkedList<String>(Arrays.asList("1","ddcsd","6"));
		
		list.add("sdfsdf");
		list.add("yt-ilk");
		//add(list);
		
		for(String item : list) {
			System.err.println(item);
		}
		
		System.err.println("size="+list.size());
		
		
//		list.add(/*Integer.valueOf(*/x/*)*/);
		String x1 = /*(String)*/list.get(0);	// list[0]
//		list.set(0,100);			// list[0] = 100;
		list.set(0,"sdfsdf");
		
		System.err.println("X1.class="+x1.getClass());
		
		System.err.println("Remove: "+list.remove(0));
		
		Set<String>		ss = new HashSet<>();
		
		ss.add("vassya");
		ss.add("petya");
		ss.add("vassya");
		
		System.err.println("Size set="+ss.size());
		
		ss.remove("vassya");
		
		for(String item : ss) {
			
		}
		
		ss.contains("petya");
		
		ss.addAll(list);		// a U b
		ss.removeAll(list);		// a - b
		ss.retainAll(list);		// a ^ b 
		
		String[]	content = ss.toArray(new String[ss.size()]);
	}
	
	static void add(final List x) {
		x.add(100);
	}

}

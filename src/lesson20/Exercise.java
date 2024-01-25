package lesson20;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Exercise {
	public static final String[]	names = {"ivanov"
			,"petrov"
			,"sidorov"
			,"ivanov"
			,"petrov"
			,"sidorov"
			,"ivanov"
			,"petrov"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,int[]> result = new HashMap<>();
		
		for(String item : names) {
			if (!result.containsKey(item)) {
				result.put(item,new int[] {0});
			}
			result.get(item)[0]++;
		}
		for (Entry<String, int[]> item : result.entrySet()) {
			System.err.println(item.getKey()+"="+item.getValue()[0]);
		}
	}

}

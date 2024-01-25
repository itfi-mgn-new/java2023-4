package lesson20;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String>	map = new HashMap<>();
		
		map.put("vassya","pupkin");
		map.put("petya","assa");
		System.err.println("Get: "+map.get("vassya"));
		map.remove("petya");
		
		for(String item : map.keySet()) {
			
		}
		for(String item : map.values()) {
			
		}
		for(Entry<String, String> item : map.entrySet()) {
			System.err.println(item.getKey()+'='+item.getValue());
		}
		System.err.println("Contains: "+map.containsKey("vassya"));
		
		
	}

}

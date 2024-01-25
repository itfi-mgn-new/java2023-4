package lesson20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>	list = new ArrayList<>(Arrays.asList(10,20,30));
		
		System.err.println(Stream.of(10,20,30).filter((y)->y <= 20).filter((z)->z > 0).count());
	}
}

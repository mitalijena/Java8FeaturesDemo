package streamapi.createstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {

	public static void main(String[] args) {
		
		//creating stream of integers
		Stream<Integer> streamWithIntegers = Stream.of(1,2,3,4);
		
		//creating stream with an array of Objects
		Stream streamWithArrayObjects = Stream.of(new Integer[] {1,2,3,4});
		
		//Not Allowed:creating stream with array of primitives
		//Stream<Integer> stream1 = Stream.of(new int[]{1,2,3,4});
		
		//creating stream with String Objects
		Stream streamWithStringObjects = Stream.of("Mitali","Manoj");
		
		//creating stream with Array of String Objects
		Stream streamWithArrayOfStringObjects = Stream.of(new String[] {"Mitali","Manoj"});
		
		//creating stream with a Collection object
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Stream<Integer> streamWithCollectionListSequential = list.stream();//creates sequential stream
		Stream<Integer> streamWithCollectionListParallel = list.stream();//creates parallel stream
	}

}

package streamapi.intemediateoperations.distinct;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamDistinctDemo {
	
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			list.add("Message"+i);
			list.add("Message"+i);
		}
		
		Stream<String> streamList = list.stream();
		
		streamList.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("Before distinct() Anonymous way of distinct() method : "+t);
			}
		});
		
		Stream<String> streamList1 = list.stream();
		Stream<String> streamDistinct = streamList1.distinct();
		
		streamDistinct.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("After distinct() Anonymous way of distinct() method : "+t);
			}
		});
		
		//Lambda way of skip() method
		list.stream()
			.distinct()
			.forEach(c -> System.out.println("Lambda way of distinct() method : "+c));
	
	}

}

package streamapi.intemediateoperations.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFilterDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			list.add("Message"+i);
		}
		
		//Creating stream from list
		Stream<String> streamList = list.stream();
		
		//Using filter() by Anonymous class way
		Stream<String> stream1 = streamList.filter(new Predicate<String>() {
			@Override
			public boolean test(String str) {
				if(!str.equalsIgnoreCase("Message5")) {
					return true;
				}
				return false;
			}			
		});
		
		//Using forEach() by Anonymous class way
		stream1.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		//Another way of writting the same thing
		list.stream()
			.filter(p -> !p.equalsIgnoreCase("Message5"))
			.forEach(c -> System.out.println(c));
	}

}

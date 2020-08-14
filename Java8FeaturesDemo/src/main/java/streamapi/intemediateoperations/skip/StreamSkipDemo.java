package streamapi.intemediateoperations.skip;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamSkipDemo {
	
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			list.add("Message"+i);
		}
		
		Stream<String> streamList = list.stream();
		
		Stream<String> streamPeek = streamList.peek(new Consumer<String>() {
			@Override
			public void accept(String value) {
				
			}
		});
		
		streamPeek.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("Anonymous way of limit() method : "+t);
			}
		});
		//Lambda way of limit() method
		list.stream()
			.peek(t -> System.out.println("Heloo : "+t))
			.forEach(c -> System.out.println("Lambda way of limit() method : "+c));
	
	}

}

package streamapi.intemediateoperations.peek;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamPeekDemo {
	
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			list.add("Message"+i);
		}
		
		Stream<String> streamList = list.stream();
		
		Stream<String> streamSkip = streamList.skip(4);
		
		streamSkip.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("Anonymous way of skip() method : "+t);
			}
		});
		
		//Lambda way of skip() method
		list.stream()
			.skip(4)
			.forEach(c -> System.out.println("Lambda way of skip() method : "+c));
	
	}

}

package streamapi.intemediateoperations.limit;

import java.util.ArrayList;
import java.util.List;

public class StreamLimitDemo {
	
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			list.add("Message"+i);
		}
		
		//Lambda way of limit() method
		list.stream()
			.limit(5)
			.forEach(c -> System.out.println(c));
	
	}

}

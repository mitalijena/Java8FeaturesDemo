package forEachMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<10;i++) {
			list.add(i);
		}
		
		//Anonymous class way-1
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("forEach anonymous class way-1 Value :"+t);
			}
		});
		
		
		//Anonymous class way-2
		Consumer consumer = new Consumer<Integer>() {			
			@Override
			public void accept(Integer t) {
				System.out.println("forEach anonymous class way-2 Value::"+t);
			}
		};
		list.forEach(consumer);
		
		
		//Traditional way
		MyConsumerImpl myConsumer = new MyConsumerImpl();
		list.forEach(myConsumer);
	}

}

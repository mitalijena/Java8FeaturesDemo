package forEachMethod;

import java.util.function.Consumer;

public class MyConsumerImpl implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println("Traditional way/reusable way for MyConsumer forEach : "+t);
	}

}

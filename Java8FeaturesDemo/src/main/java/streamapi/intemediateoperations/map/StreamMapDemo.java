package streamapi.intemediateoperations.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamMapDemo {

	public static void main(String[] args) {
		
		//map() method call
		mapDemo();
		
		//mapToDouble() method call
		mapToDoubleDemo();
		
		//mapToInt() method call
		mapToIntDemo();
		
		//mapTolong() method call
		mapToLongDemo();
	}
	
	public static void  mapDemo() {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		//Creating stream from list
		Stream<Integer> streamList = list.stream();
		
		//Using filter() by Anonymous class way
		Stream<Integer> stream1 = streamList.filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				if(integer > 5) {
					return true;
				}
				return false;
			}			
		});
		
		//Using map() by Anonymous class way
		Stream<Integer> stream2 = stream1.map(new Function<Integer,Integer>() {
			@Override
			public Integer apply(Integer integer) {
				Integer finalInt = integer * 10;
				return finalInt;
			}
		});
		
		//Using forEach() by Anonymous class way
		stream2.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer integer) {
				System.out.println("map() Anonymous way : "+integer);
			}
		});
		
		//Another way of writting the same thing
		list.stream()
			.filter(p -> p > 5)
			.map(t -> "map() Lambda way : " +t)
			.forEach(c -> System.out.println(c));
	 }
	
	public static void mapToDoubleDemo() {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		//Creating stream from list
		Stream<Integer> streamList = list.stream();
		
		//Using filter() by Anonymous class way
		Stream<Integer> stream1 = streamList.filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				if(integer < 5) {
					return true;
				}
				return false;
			}			
		});
		
		//Using map() by Anonymous class way
		DoubleStream stream2 = stream1.mapToDouble(new ToDoubleFunction<Integer>() {
			@Override
			public double applyAsDouble(Integer value) {
				Integer finalDouble = value * 100;
				return finalDouble;
			}
		});
		
		//Using forEach() by Anonymous class way
		stream2.forEach(new DoubleConsumer() {
			@Override
			public void accept(double value) {
				System.out.println("mapToDouble() Anonymous way : " +value);
			}
		});
		
		//Another way of writting the same thing
		list.stream()
			.filter(p -> p < 5)
			.mapToDouble(t -> t*10)
			.forEach(c -> System.out.println(c));
	}
	
	public static void mapToIntDemo() {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		//Creating stream from list
		Stream<Integer> streamList = list.stream();
		
		//Using filter() by Anonymous class way
		Stream<Integer> stream1 = streamList.filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				if(integer > 6 && integer < 9) {
					return true;
				}
				return false;
			}			
		});
		
		//Using map() by Anonymous class way
		IntStream stream2 = stream1.mapToInt(new ToIntFunction<Integer>() {
			@Override
			public int applyAsInt(Integer value) {
				Integer finalInt = value * 1000;
				return finalInt;
			}
		});
		
		//Using forEach() by Anonymous class way
		stream2.forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.println("mapToInt() Anonymous way : " +value);
			}
		});
		
		//Another way of writting the same thing
		list.stream()
			.filter(p -> p > 6 && p < 9)
			.mapToInt(t -> t*10)
			.forEach(c -> System.out.println(c));
	 }
	
	public static void mapToLongDemo() {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 50; i < 200; i++) {
			list.add(i);
		}
		
		//Creating stream from list
		Stream<Integer> streamList = list.stream();
		
		//Using filter() by Anonymous class way
		Stream<Integer> stream1 = streamList.filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				if(integer > 100) {
					return true;
				}
				return false;
			}			
		});
		
		//Using map() by Anonymous class way
		LongStream stream2 = stream1.mapToLong(new ToLongFunction<Integer>() {
			@Override
			public long applyAsLong(Integer value) {
				Integer finalLong = value * 5;
				return finalLong;
			}
		});
		
		//Using forEach() by Anonymous class way
		stream2.forEach(new LongConsumer() {
			@Override
			public void accept(long value) {
				System.out.println("mapToLong() Anonymous way : " +value);
			}
		});
		
		//Another way of writting the same thing
		list.stream()
			.filter(p -> p > 100 )
			.mapToLong(t -> t*5)
			.forEach(c -> System.out.println(c));
	}
}

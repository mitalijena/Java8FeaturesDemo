package streamapi.intemediateoperations.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamFlatMapDemo {

	public static void main(String[] args) {
		
		//flatMap() method call
		flatMapDemo();
		
		//flatMapToDouble() method call
		flatMapToDoubleDemo();
		
		//flatMapToInt() method call
		flatMapToIntDemo();
		
		//flatMapTolong() method call
		flatMapToLongDemo();
	}
	
	public static void  flatMapDemo() {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<String> list2 = new ArrayList<String>();
		for(int i=0;i<10;i++) {
			list1.add(i);
		}
		for(int i=0;i<10;i++) {
			list2.add("String"+i);
		}
		
		List<ArrayList> listOfLists = new ArrayList<ArrayList>();
		listOfLists.add(list1);
		listOfLists.add(list2);
		
		//Anonymous way
		Stream<ArrayList> listStream = listOfLists.stream().flatMap(new Function<ArrayList, Stream<ArrayList>>() {
			@Override
			public Stream<ArrayList> apply(ArrayList t) {
				Stream<ArrayList> streamOfLists = t.stream();
				return streamOfLists;
			}
		});
		
		listStream.forEach(new Consumer<Object>() {
			@Override
			public void accept(Object t) {
				System.out.println("flatMap() Anonymous way : "+t);
			}
		});
		
		//Lambda way
		listOfLists.stream()
				   .flatMap(list -> Stream.of(list))
				   .forEach(c ->System.out.println("flatMap() Lambda way : "+c));
		
	}
	
	public static void flatMapToDoubleDemo() {
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		for(int i=0;i<10;i++) {
			list1.add(String.valueOf(i));
		}
		for(int i=10;i<20;i++) {
			list1.add(String.valueOf(i));
		}
		
		List<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
		listOfLists.add(list1);
		listOfLists.add(list2);
		
		//Anonymous way-list of Strings
		DoubleStream listStream = list1.stream().flatMapToDouble(new Function<String, DoubleStream>() {
			@Override
			public DoubleStream apply(String t) {
				DoubleStream ds = DoubleStream.of(Double.parseDouble(t));
				return ds;
			}

		});
		
		listStream.forEach(new DoubleConsumer() {
			@Override
			public void accept(double value) {
				System.out.println("flatMapToDouble() Anonymous way : "+value);
			}
		});
		
		//Lambda way-list of Strings
		list1.stream()
				   .flatMapToDouble(num -> DoubleStream.of(Double.parseDouble(num)))
				   .forEach(c ->System.out.println("flatMapToDouble() Lambda way : "+c));
		
		
		//Anonymous way-list of lists
		DoubleStream listStream1 = listOfLists.stream().flatMapToDouble(new Function<ArrayList<String>, DoubleStream>() {
			@Override
			public DoubleStream apply(ArrayList<String> t) {
				return t.stream().flatMapToDouble(new Function<String, DoubleStream>() {

					@Override
					public DoubleStream apply(String t) {
						DoubleStream ds = DoubleStream.of(Double.parseDouble(t));
						return ds;
					}
					
				});
				
			}

		});
		
		listStream1.forEach(new DoubleConsumer() {
			@Override
			public void accept(double value) {
				System.out.println("flatMapToDouble() Anonymous way : "+value);
			}
		});
		
		//Lambda way-list of Strings
		listOfLists.stream()
		   		   .flatMapToDouble(list -> list.stream().mapToDouble(num -> Double.parseDouble(num)))//num -> DoubleStream.of(Double.parseDouble(num))
		   		   .forEach(c ->System.out.println("flatMapToDouble() Lambda way : "+c));
		
	}
	
	public static void flatMapToIntDemo() {
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		for(int i=0;i<10;i++) {
			list1.add(String.valueOf(i));
		}
		for(int i=10;i<20;i++) {
			list1.add(String.valueOf(i));
		}
		
		List<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
		listOfLists.add(list1);
		listOfLists.add(list2);
		
		//Anonymous way-list of Strings
		IntStream listStream = list1.stream().flatMapToInt(new Function<String, IntStream>() {
			@Override
			public IntStream apply(String t) {
				IntStream ds = IntStream.of(Integer.parseInt(t));
				return ds;
			}

		});
		
		listStream.forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.println("flatMapToInt() Anonymous way : "+value);
			}
		});
		
		//Lambda way-list of Strings
		list1.stream()
				   .flatMapToInt(num -> IntStream.of(Integer.parseInt(num)))
				   .forEach(c ->System.out.println("flatMapToInt() Lambda way : "+c));
		
		
		//Anonymous way-list of lists
		IntStream listStream1 = listOfLists.stream().flatMapToInt(new Function<ArrayList<String>, IntStream>() {
			@Override
			public IntStream apply(ArrayList<String> t) {
				return t.stream().flatMapToInt(new Function<String, IntStream>() {

					@Override
					public IntStream apply(String t) {
						IntStream ds = IntStream.of(Integer.parseInt(t));
						return ds;
					}
					
				});
				
			}

		});
		
		listStream1.forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.println("flatMapToInt() Anonymous way : "+value);
			}
		});
		
		//Lambda way-list of Strings
		listOfLists.stream()
		   		   .flatMapToInt(list -> list.stream().mapToInt(num -> Integer.parseInt(num)))//num -> DoubleStream.of(Double.parseDouble(num))
		   		   .forEach(c ->System.out.println("flatMapToInt() Lambda way : "+c));
		
	
	}
	
	public static void flatMapToLongDemo() {
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		for(int i=0;i<10;i++) {
			list1.add(String.valueOf(i));
		}
		
		for(int i=100;i<200;i++) {
			list1.add(String.valueOf(i));
		}
		
		ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
		listOfLists.add(list1);
		listOfLists.add(list2);
		
		//Anonymous way- List of Strings
		LongStream longStream = list1.stream().flatMapToLong(new Function<String, LongStream>(){
			@Override
			public LongStream apply(String value) {
				LongStream ls = LongStream.of(Long.valueOf(value));
				return ls;
			}
		});
		
		longStream.forEach(new LongConsumer() {
			@Override
			public void accept(long value) {
				System.out.println("flatMapToLong() for ArrayList of Strings in Anonymous way : "+value);
			}
		});
		
		//Lambda way-List of Strings
		list1.stream()
		     .flatMapToLong(num -> LongStream.of(Long.valueOf(num)))
		     .forEach(c -> System.out.println("flatMapToLong() for ArrayList of Strings in Lambda way : "+c));
		
		//Anonymous way - List of ArrayLists of Strings
		LongStream longstream1 = listOfLists.stream().flatMapToLong(new Function<ArrayList<String>, LongStream>(){
			@Override
			public LongStream apply(ArrayList<String> list) {
				
				return list.stream().flatMapToLong(new Function<String, LongStream>() {
					@Override
					public LongStream apply(String str) {
						return LongStream.of(Long.valueOf(str));
					}
				});
			}
		});
		
		longstream1.forEach(new LongConsumer() {
			@Override
			public void accept(long value) {
				System.out.println("flatMapToLong() for ArrayList of ArrayLists of Strings in Anonymous way : "+value);
			}
		});
		
		//Lambda way-ArrayList of ArrayLists of Strings
		listOfLists.stream()
				   .flatMapToLong(list -> list.stream().flatMapToLong(num -> LongStream.of(Long.valueOf(num))))
				   //.flatMapToLong(list -> list.stream().mapToLong(num -> Long.valueOf(num)))
				   .forEach(num -> System.out.println("flatMapToLong() for ArrayList of ArrayLists of Strings in Lambda way : "+num));
	}
}

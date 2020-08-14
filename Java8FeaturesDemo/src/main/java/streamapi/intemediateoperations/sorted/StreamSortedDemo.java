package streamapi.intemediateoperations.sorted;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamSortedDemo {
	
	public static void main(String[] args) {
		
		//Default sorting order for Integers
		sortingIntegersWithNaturalSortingOrder();
		
		//Default sorting order for Strings
		sortingStringsWithNaturalSortingOrder();
		
		//Comparator sorting order for Objects Comparator defined in Anonymous way
		sortingObjectsWithComparatorSortingOrder();
		
		//Comparator sorting order for Objects Comparator defined in separate comparator class in Anonymous way
		sortingObjectsWithComparatorSortingOrder1();
		
		//Comparator sorting order for Objects Comparator defined in separate comparator class in Lambda way
		sortingObjectsWithComparatorSortingOrder2();
	}
	
	public static void sortingIntegersWithNaturalSortingOrder() {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		Stream<Integer> streamList = list.stream();
		
		Stream<Integer> sortedIntStream = streamList.sorted();
		
		sortedIntStream.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {
				System.out.println("Anonymous way of sorted() method for Integers: "+i);
			}
		});
		
		//Lambda way of sorted() method
		list.stream()
			.sorted()
			.forEach(c -> System.out.println("Lambda way of sorted() method for Integers: "+c));
	}
	
	public static void sortingStringsWithNaturalSortingOrder() {
		
		List<String> list1 = new ArrayList<String>();
		list1.add("Apple");
		list1.add("Zebra");
		list1.add("Indigo");
		list1.add("Banana");
	
		Stream<String> streamList1 = list1.stream();
		
		Stream<String> sortedStrStream = streamList1.sorted();
		
		sortedStrStream.forEach(new Consumer<String>() {
			@Override
			public void accept(String str) {
				System.out.println("Anonymous way of sorted() method for Strings : "+str);
			}
		});
		
		//Lambda way of sorted() method
		list1.stream()
			.sorted()
			.forEach(c -> System.out.println("Lambda way of sorted() method for Strings: "+c));
	}
	
	public static void sortingObjectsWithComparatorSortingOrder() {
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(34, "product34", "costing", 10));
		products.add(new Product(23, "product34", "costing", 50));
		products.add(new Product(90, "product34", "costing", 40));
		products.add(new Product(45, "product34", "costing", 60));
		products.add(new Product(83, "product34", "costing", 20));
		
		Stream<Product> sortedProductList = products.stream().sorted(new MyComparator() {
			@Override
			public int compare(Product p1, Product p2) {
				if(p1.getPid() < p2.getPid()) {
					return 1;
				} else if(p1.getPid() > p2.getPid()) {
					return -1;
				} else
					return 0;
			}
		});
		
		sortedProductList.forEach(new Consumer<Product>() {
			@Override
			public void accept(Product product) {
			System.out.println("Comparator in anonymous way : Product : "+product.toString());	
			}
		});
	}
	
	public static void sortingObjectsWithComparatorSortingOrder1() {
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(34, "product34", "costing", 10));
		products.add(new Product(23, "product34", "costing", 50));
		products.add(new Product(90, "product34", "costing", 40));
		products.add(new Product(45, "product34", "costing", 60));
		products.add(new Product(83, "product34", "costing", 20));
		
		MyComparator myComparator = new MyComparator();
		
		Stream<Product> sortedProductList = products.stream().sorted(myComparator);
		
		sortedProductList.forEach(new Consumer<Product>() {
			@Override
			public void accept(Product product) {
			System.out.println("Separate Comparator & Anonymous way : Product : "+product.toString());	
			}
			
		});
	}
	
	public static void sortingObjectsWithComparatorSortingOrder2() {
		
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(34, "product34", "costing", 10));
		products.add(new Product(23, "product34", "costing", 50));
		products.add(new Product(90, "product34", "costing", 40));
		products.add(new Product(45, "product34", "costing", 60));
		products.add(new Product(83, "product34", "costing", 20));
		
		
		products.stream()
				.sorted(new MyComparator())
				.forEach(p -> System.out.println("Separate Comparator Lambda way : Product : "+p));
		
	}

}

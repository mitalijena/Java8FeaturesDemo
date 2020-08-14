package streamapi.practicestreamapiproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeDemo {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList();
		list.add(new Employee(1, "A", 30));
		list.add(new Employee(2, "B", 25));
		list.add(new Employee(3, "C", 26));
		list.add(new Employee(4, "D", 17));
		list.add(new Employee(5, "E", 23));
		list.add(new Employee(6, "F", 23));
		list.add(new Employee(6, "G", 29));

		// With duplicates
		list.stream().collect(Collectors.toList()).forEach(System.out::println);

		// In plain Java
		HashSet<Employee> hashSet = new HashSet(list);
		for (Employee employee : hashSet) {
			System.out.println(employee.toString());
		}

		// Using Stream API
		System.out.println("----------By Stream API : Removing Duplicates based on Age---------");
		list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);

		// Filtering out employees where name starts with C
		System.out.println("----------By Stream API : Removing employees with name starts with C ---------");
		list.stream().filter(emp -> !emp.getEmpName().startsWith("C")).collect(Collectors.toList())
				.forEach(System.out::println);

		// Number of employees with same empId
		Map<Integer, List<String>> map = list.stream().collect(Collectors.groupingBy(Employee::getEmpId,
				Collectors.mapping(Employee::getEmpName, Collectors.toList())));		
		map.forEach((k,v) -> System.out.println("Key : "+k+ " : value : " +v.toString()));
	}

}

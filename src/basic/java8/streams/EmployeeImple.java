package basic.java8.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeImple {
	public static void main(String args[]) {

		List<Employee> emL = new ArrayList<>();
		Employee e1 = new Employee("c1", 1, "A", "AA");
		Employee e2 = new Employee("c2", 2, "B", "BB");
		Employee e3 = new Employee("c3", 3, null, "X");
		Employee e4 = new Employee("c4", 4, null, "X");
		Employee e5 = new Employee("c5", 5, "C", "CC");
		Employee e6 = new Employee("c6", 6, "B", "BB");
		Employee e7 = new Employee("c7", 7, "A", "AA");
		Employee e8 = new Employee("c8", 8, null, "X");
		Employee e9 = new Employee("c9", 9, "D", "DD");
		Employee e10 = new Employee("c10", 10, "E", "EE");
		emL.add(e1);
		emL.add(e2);
		emL.add(e3);
		emL.add(e4);
		emL.add(e5);
		emL.add(e6);
		emL.add(e7);
		emL.add(e8);
		emL.add(e9);
		emL.add(e10);
		
		List<String> ss = emL.stream().filter(x->x.getCity()!=null).map(x->x.getName().toUpperCase()).collect(Collectors.toList());
		ss.forEach(System.out::println);
		emL.stream().filter(x->x.getCity()!=null).collect(Collectors.toList()).stream().forEach(x->System.out.println(x.getId()));
		
		//{A=2, B=2, C=1, D=1, E=1}
		Map<String, Long> map = emL.stream().filter(e -> e.getCity() != null)
				.collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
		//System.out.println(map);
		
		//grouping as per city or country if city is null
		//{A=[c1, c7], B=[c2, c6], C=[c5], D=[c9], E=[c10], X=[c3, c4, c8]}
		List<Employee> nullCityEmp = emL.stream().filter(e -> e.getCity() == null).collect(Collectors.toList());
		List<Employee> nonNullCityEmp = emL.stream().filter(e -> e.getCity() != null).collect(Collectors.toList());
		Map<String, List<String>> map1 = nonNullCityEmp.stream().collect(
				Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toList())));
		Map<String, List<String>> map2 = nullCityEmp.stream().collect(
				Collectors.groupingBy(Employee::getCountry, Collectors.mapping(Employee::getName, Collectors.toList())));
		map1.putAll(map2);
		
		System.out.println("here = " + map1);
	}
}

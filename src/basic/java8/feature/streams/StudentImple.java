package basic.java8.feature.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentImple {
	public static void main(String args[]) {

		/*
		 * public Employee(String name, int id, String city, String country) {
		super();
		this.name = name;
		this.id = id;
		this.city = city;
		this.country = country;
	}	 */
		List<Student> emL = new ArrayList<>();
		Student e1 = new Student("c1", 1, "A", "AA");
		Student e2 = new Student("c2", 2, "B", "BB");
		Student e3 = new Student("c3", 3, null, "X");
		Student e4 = new Student("c4", 4, null, "X");
		Student e5 = new Student("c5", 5, "C", "CC");
		Student e6 = new Student("c6", 6, "B", "BB");
		Student e7 = new Student("c7", 7, "A", "AA");
		Student e8 = new Student("c8", 8, null, "X");
		Student e9 = new Student("c9", 9, "D", "DD");
		Student e10 = new Student("c10", 10, "E", "EE");
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
				.collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));
		//System.out.println(map);
		//grouping as per city or country if city is null
		//{A=[c1, c7], B=[c2, c6], C=[c5], D=[c9], E=[c10], X=[c3, c4, c8]}
		List<Student> nullCityEmp = emL.stream().filter(e -> e.getCity() == null).collect(Collectors.toList());
		List<Student> nonNullCityEmp = emL.stream().filter(e -> e.getCity() != null).collect(Collectors.toList());
		Map<String, List<String>> map1 = nonNullCityEmp.stream().collect(
				Collectors.groupingBy(Student::getCity, Collectors.mapping(Student::getName, Collectors.toList())));
		Map<String, List<String>> map2 = nullCityEmp.stream().collect(
				Collectors.groupingBy(Student::getCountry, Collectors.mapping(Student::getName, Collectors.toList())));
		map1.putAll(map2);
		//another simpler approach
		Map<String, List<String>> map3 = emL.stream().collect(
				Collectors.groupingBy(e->e.getCity()!=null?e.getCity():e.getCountry(), 
						Collectors.mapping(Student::getName, Collectors.toList())));
		
		
		System.out.println("here = " + map3);
	}
}

















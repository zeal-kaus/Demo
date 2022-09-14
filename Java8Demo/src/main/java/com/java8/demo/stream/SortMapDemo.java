package com.java8.demo.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortMapDemo {

	/*
	 * ----start---- Conventional or older way to sort the map using
	 * Collections.sort method
	 */
	static void usingConventionalWay(Map<String, Integer> map) {
		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}

		});

		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
	}

	/* Now sort the Map using Java8 Lambda Expression */
	static void usingLambdaExp(Map<String, Integer> map) {

		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + "  " + entry.getValue());
		}
	}

	/* Now sort the Map using Java8 stream */
	static void usingStream(Map<String, Integer> map) {
		//for primitive data type
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		//Reverse
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
	}
	
	/* Now sort the Map using Java8 stream */
	static void usingStreamforNonPrimitive(Map<Employee, Integer> map) {
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Integer::intValue))).forEach(System.out::println);
		
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("five", 5);
		map.put("eight", 8);
		
		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);

		//System.out.println(employeeMap);
		
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(176, "Roshan", "IT", 600000));
		empList.add(new Employee(388, "Bikash", "CIVIL", 900000));
		empList.add(new Employee(470, "Bimal", "DEFENCE", 500000));
		empList.add(new Employee(624, "Sourav", "CORE", 400000));
		empList.add(new Employee(284, "Prakash", "SOCIAL", 1200000));
		
    /*
     * for(Employee emp : empList) { if(!emp.getName().equalsIgnoreCase("Roshan")) { emp.setName("R1"); }
     * System.out.println(emp.toString()); }
     */
		
		//empList.stream().filter(emp -> emp.getSalary() > 500000).forEach(emp -> System.out.println(emp.getName()));
		
		//usingStream(map);
		empList.stream().filter(e -> (e.getSalary()>900000)).collect(Collectors.toList()).forEach(e -> System.out.println(e.getDept()));
	}

}

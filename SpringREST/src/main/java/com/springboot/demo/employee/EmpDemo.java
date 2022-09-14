package com.springboot.demo.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class EmpDemo {

	public static void main(String[] args) {

		Set<Employee> ts = new HashSet<Employee>();
		ts.add(new Employee("A", 31));
		ts.add(new Employee("A", 31));
		ts.add(new Employee("A", 31));
		ts.add(new Employee("A", 31));

		System.out.println(ts);
		System.out.println("--------------------------------");
		//ts.stream().sorted((o1, o2) -> o1.compareTo(o2)).forEach(System.out::println);

		/*
		 * List list = Collections.synchronizedList(new ArrayList<Object>());
		 * 
		 * Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		 * System.out.println(streamIterated);
		 */
	}

}

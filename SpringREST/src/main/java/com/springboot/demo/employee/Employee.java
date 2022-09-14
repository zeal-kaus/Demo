package com.springboot.demo.employee;

public class Employee /* implements Comparable<Employee> */ {

	private Address adress;
	private String name;
	private int age; // dsc

	
	public Employee() {
		super();
	}

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Employee [name= " + name + ", age= " + age + "]";
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	/*
	 * @Override public int compareTo(Employee o) { return this.getAge() <
	 * ((Employee) o).getAge() ? 1 : (this.getAge() == ((Employee) o).getAge()) ? 0
	 * : -1; }
	 */

}

package com.springboot.demo.employee;

import org.springframework.stereotype.Component;

@Component("add")
public class Address implements Comparable<Address> {

	private String city; // asc
	private String state;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int compareTo(Address o) {
		return this.getCity().equalsIgnoreCase(((Address) o).getCity()) ? -1
				: (this.getCity().equalsIgnoreCase(((Address) o).getCity())) ? 0 : 1;
	}
}

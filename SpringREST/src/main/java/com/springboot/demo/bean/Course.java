package com.springboot.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.springboot.demo.employee.Address;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String description;
	@Autowired
	@Qualifier("add")
	private Address address;

	public Course() {
		super();
	}

	public Course(String id, String name, String description, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

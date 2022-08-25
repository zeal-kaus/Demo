package com.emp.demo;

import org.springframework.boot.SpringApplication;

import com.emp.demo.service.EmpServiceImpl;

public class EmpLeaveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpLeaveDemoApplication.class, args);
		new EmpServiceImpl().startOperation();
	}
}

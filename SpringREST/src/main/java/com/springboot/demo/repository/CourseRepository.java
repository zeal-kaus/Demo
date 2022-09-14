package com.springboot.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.demo.bean.Course;

public interface CourseRepository extends CrudRepository<Course, String>{

	
}

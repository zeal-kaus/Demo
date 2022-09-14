package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.bean.Course;
import com.springboot.demo.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping("/courses")
	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	@RequestMapping("/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/courses")
	public List<Course> addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
	public List<Course> updateCourse(@PathVariable String id, @RequestBody Course course) {
		return courseService.updateCourse(id, course);
	}

	@RequestMapping("/courses/delete/{id}")
	public List<Course> deleteCourse(@PathVariable String id) {
		return courseService.deleteCourse(id);
	}
}

package com.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.bean.Course;
import com.springboot.demo.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses() {
		return (List<Course>) courseRepository.findAll();
	}

	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}

	public List<Course> deleteCourse(String id) {
		courseRepository.deleteById(id);
		return this.getCourses();
	}

	public List<Course> addCourse(Course course) {
		courseRepository.save(course);
		return this.getCourses();
	}

	public List<Course> updateCourse(String id, Course course) {
		courseRepository.save(course);
		return this.getCourses();
	}

	/*
	 * public List<Course> getCourses() { return this.courses; }
	 * 
	 * public Course getCourse(String id) { return this.courses.stream().filter(t ->
	 * t.getId().equals(id)).findFirst().get(); }
	 * 
	 * public List<Course> deleteCourse(String id) {
	 * 
	 * Iterator<Course> iterator = this.courses.iterator(); while
	 * (iterator.hasNext()) { Course course = (Course) iterator.next(); if
	 * (course.getId().equals(id)) { iterator.remove(); break; } } return
	 * this.courses;
	 * 
	 * }
	 * 
	 * public List<Course> addCourse(Course course) {
	 * 
	 * this.courses.add(course); return this.courses;
	 * 
	 * }
	 * 
	 * public List<Course> updateCourse(String id, Course course) {
	 * 
	 * for (int i = 0; i < courses.size(); i++) { if
	 * (courses.get(i).getId().equals(id)) { courses.set(i, course); } } return
	 * this.courses;
	 * 
	 * }
	 */
}

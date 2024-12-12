package com.jm.lms.studentms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.lms.studentms.model.Course;
import com.jm.lms.studentms.repository.CourseViewCourseListRepository;

@Service
public class CourseViewCourseListService {
	@Autowired
	private CourseViewCourseListRepository repository;

	public List<Course> viewAllcourses() {
		return repository.findAll();
	}
	
	public Course addCourse(Course course) {
		return repository.save(course);
	}



}

package com.jm.lms.studentms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.lms.studentms.model.Course;
import com.jm.lms.studentms.repository.CourseViewCourseListRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CourseViewCourseListService {
	@Autowired
	private CourseViewCourseListRepository repository;

	public List<Course> viewAllcourses() {
		List<Course> course= repository.findAll();
		log.info("Response from courses"+course);
		return course;
	}
	
	public Course addCourse(Course course) {
		Course courses=repository.save(course);
		return courses;
	}



}

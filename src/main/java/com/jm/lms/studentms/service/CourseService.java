package com.jm.lms.studentms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.lms.studentms.model.Course;
import com.jm.lms.studentms.repository.CourseRepository;
@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
	
	public Course addCourse(Course course) {
		return repository.save(course);
	}

	public List<Course> getAll() {
		return repository.findAll();
	}

}

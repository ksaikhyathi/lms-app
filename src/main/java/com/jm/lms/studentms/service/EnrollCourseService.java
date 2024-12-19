
package com.jm.lms.studentms.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.jm.lms.studentms.model.EnrollCourse;
import com.jm.lms.studentms.repository.EnrollCourseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnrollCourseService {
	
	private final EnrollCourseRepository enrollCourseRepository;
	
	 public EnrollCourseService(EnrollCourseRepository enrollCourseRepository) {
	     
	        this.enrollCourseRepository = enrollCourseRepository;
	    }
	 


	public EnrollCourse saveEnrollCourse(EnrollCourse enrollcourse) {
		log.info("saveenrollcourse"+enrollcourse);
		return enrollCourseRepository.save(enrollcourse);

	}

	public List<EnrollCourse> getAllEnrollCourse() {
		 List<EnrollCourse> newEnroll= (List<EnrollCourse>) enrollCourseRepository.findAll();
	        return newEnroll;
	    }
}

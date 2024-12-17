package com.jm.lms.studentms.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.jm.lms.studentms.model.CourseDetails;
import com.jm.lms.studentms.repository.ViewCourseDetailsRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ViewCourseDetailsService {
	
	@Autowired
	private ViewCourseDetailsRepository viewCourseDetailsRepository;

	public List<CourseDetails> getAllCourseDetails() {
		log.info("Fetching all course details from repository");
		return viewCourseDetailsRepository.findAll();
	}

	public CourseDetails addCourseDetails(CourseDetails coursedetails) {
		log.info("Saving new course details: {}", coursedetails);
		return viewCourseDetailsRepository.save(coursedetails);
	}
	public CourseDetails updateCourseDetailsById(Long id, CourseDetails coursedetails) {
	    CourseDetails existingCourse = viewCourseDetailsRepository.findById(id).orElse(null);

	if (existingCourse == null) {
		log.warn("Course not found with id: {}", id);
		return null; 
	}
	    
	    existingCourse.setCourseName(coursedetails.getCourseName());
	    existingCourse.setCourseDescription(coursedetails.getCourseDescription());
	    existingCourse.setCourseInstructor(coursedetails.getCourseInstructor());
	    log.info("Saving updated course details for id: {}", id);
	    return viewCourseDetailsRepository.save(existingCourse);
	}

	public CourseDetails updateCourseDetailsByFields(Long id, Map<String, Object> fields) {
		Optional<CourseDetails> existingCourseDetails = viewCourseDetailsRepository.findById(id);
    
	if(existingCourseDetails.isPresent()){
		fields.forEach((key,val)->{
	    Field field =  ReflectionUtils.findField(CourseDetails.class, key);
	    field.setAccessible(true);
	    ReflectionUtils.setField(field,existingCourseDetails.get(),val);
	    log.info("Updated field: {} with value: {} for id: {}", key, val, id);
	});
	    log.info("Saving partially updated course details for id: {}", id);
	    return viewCourseDetailsRepository.save(existingCourseDetails.get());
	}
	    log.warn("Course not found with id: {}", id);
		return null;
	}

	public void deleteCourseById(Long id) {
	    viewCourseDetailsRepository.deleteById(id);
	    log.info("Successfully deleted course with id: {}", id);
			
	}

}
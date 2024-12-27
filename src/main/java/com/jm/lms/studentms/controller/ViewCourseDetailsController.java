package com.jm.lms.studentms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.lms.studentms.model.CourseDetails;
import com.jm.lms.studentms.service.ViewCourseDetailsService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/lms/coursedetails")
public class ViewCourseDetailsController {
	@Autowired
	private ViewCourseDetailsService viewCourseDetailsService;

	@GetMapping()
	public ResponseEntity<List<CourseDetails>> getAllCourseDetails() {
		List<CourseDetails> coursedetails = viewCourseDetailsService.getAllCourseDetails();
		log.info("Fetching all course details");
		return ResponseEntity.ok(coursedetails);
	}

	@PostMapping("/add")
	public ResponseEntity<CourseDetails> addCourseDetails(@Valid @RequestBody CourseDetails coursedetails) {
		CourseDetails savedcourse = viewCourseDetailsService.addCourseDetails(coursedetails);
		log.info("Adding new course details: {}", coursedetails);
		return ResponseEntity.ok(savedcourse);
	}

	@PutMapping("/update/{id}")
	public CourseDetails updateCourseDetaildById(@PathVariable("id") Long id,
			@Valid @RequestBody CourseDetails coursedetails) {
		log.info("Updating course details for id: {}", id);
		return viewCourseDetailsService.updateCourseDetailsById(id, coursedetails);
	}

	@PatchMapping("/update/{id}")
	public CourseDetails updateCourseDetailsByFields(@PathVariable("id") Long id,
			@RequestBody Map<String, Object> fields) {
		log.info("Updating specific fields of course details for id: {}", id);
		return viewCourseDetailsService.updateCourseDetailsByFields(id, fields);
	}

	@DeleteMapping("/{courseId}")
	public ResponseEntity<?> deleteCourseById(@PathVariable("courseId") Long id) {
		log.info("Deleting course with id: {}", id);
		viewCourseDetailsService.deleteCourseById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
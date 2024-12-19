package com.jm.lms.studentms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jm.lms.studentms.model.EditCourse;
import com.jm.lms.studentms.service.EditCourseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/lms/editCourse")

public class EditCourseController {

	public EditCourseController(EditCourseService editCourseService) {
	}

	@PutMapping("/{courseId}")
	public ResponseEntity<EditCourse> updateCourseById(@RequestBody EditCourse course,
			@PathVariable("courseId") Long id) {
		EditCourse updated = EditCourseService.updateCourseById(course, id);
		log.info("update the edit course details");
		return ResponseEntity.accepted().body(updated);
	}

}

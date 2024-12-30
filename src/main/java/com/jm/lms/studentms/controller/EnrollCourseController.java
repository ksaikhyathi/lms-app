package com.jm.lms.studentms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.lms.studentms.model.EnrollCourse;
import com.jm.lms.studentms.service.EnrollCourseService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/lms/enroll")
public class EnrollCourseController {
	
	private final EnrollCourseService enrollCourseService;
	
	 public EnrollCourseController(EnrollCourseService enrollCourseService) {
	        this.enrollCourseService = enrollCourseService;
	    }
	 @PostMapping("/enroll")
	    public ResponseEntity<EnrollCourse> saveEnrollCourse(@RequestBody @Valid  EnrollCourse enrollcourse) {
		 log.info("Enrollcourse"+enrollcourse);
	        EnrollCourse newEnroll = enrollCourseService.saveEnrollCourse(enrollcourse);
	        return ResponseEntity.ok(newEnroll);
	    }
	 @GetMapping("/get")
	    public ResponseEntity<List<EnrollCourse>> getAllEnrollCourse() {
	        List<EnrollCourse> newEnroll = enrollCourseService.getAllEnrollCourse();
	        return ResponseEntity.ok(newEnroll);
	    }
}

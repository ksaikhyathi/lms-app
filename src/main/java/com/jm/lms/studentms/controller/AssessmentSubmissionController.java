package com.jm.lms.studentms.controller;

import java.util.List; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.lms.studentms.model.Assessment;
import com.jm.lms.studentms.service.AssessmentSubmissionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/lms/assessment")
public class AssessmentSubmissionController {

    private  AssessmentSubmissionService assessmentSubmissionService;
    
    @GetMapping
	public List<Assessment> getAllAssessment() {
		return assessmentSubmissionService.getAllAssessments();	
	}
    @PostMapping("/add")
	public ResponseEntity<Assessment> addAssessment(@RequestBody @Valid Assessment assessment) {
		Assessment savedAssessment = assessmentSubmissionService.addAssessment(assessment);
		return ResponseEntity.ok(savedAssessment);
	}
    @DeleteMapping("/{assessmentId}")
	public ResponseEntity<?> deleteAssessmentById(@PathVariable("assessmentId") Long id) {
		assessmentSubmissionService.deleteAssessmentById(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
    @PutMapping("/{updateId}")
	public ResponseEntity<Assessment> updateAssessment(@PathVariable("updateId") Long id, @RequestBody Assessment assessment) {
		Assessment updatedAssessment = assessmentSubmissionService.updateAssessment(assessment);
		return ResponseEntity.ok(updatedAssessment);
	}
  
    
}


package com.jm.lms.studentms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.lms.studentms.model.Assessment;
import com.jm.lms.studentms.repository.AssessmentSubmissionRepository;

@Service
public class AssessmentSubmissionService {
	@Autowired
	private AssessmentSubmissionRepository assessmentSubmissionRepository;

	// Fetch all assessments
	public List<Assessment> getAllAssessments() {
		return assessmentSubmissionRepository.findAll();
	}

	// Add a new assessment
	public Assessment addAssessment(Assessment assessment) {
		return assessmentSubmissionRepository.save(assessment);
	}

	// Delete a assessment by ID
	public void deleteAssessmentById(Long id) {
		assessmentSubmissionRepository.deleteById(id);
	}

	// Update an existing assessment
	public Assessment updateAssessment(Assessment assessment) {
		return assessmentSubmissionRepository.save(assessment);
	}

}

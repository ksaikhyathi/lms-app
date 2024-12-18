package com.jm.lms.studentms.service;

import org.springframework.stereotype.Service;
import com.jm.lms.studentms.model.EditCourse;
import com.jm.lms.studentms.repository.EditCourseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class EditCourseService {
	private static EditCourseRepository editCourseRepository;

	public EditCourseService(EditCourseRepository editCourseRepository) {
		EditCourseService.editCourseRepository = editCourseRepository;

	}

	public static EditCourse updateCourseById(EditCourse course, Long id) {
		log.info("editCourseId" + id + ", Course: " + course);
		return editCourseRepository.save(course);
	}

}

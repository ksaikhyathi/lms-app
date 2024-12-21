package com.jm.lms.studentms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.lms.studentms.model.LessonDetails;
import com.jm.lms.studentms.service.ViewLessonDetailsService;

@RestController
@RequestMapping("api/v1/lms/lessondetails")
public class ViewLessonDetailsController {
	@Autowired
	private ViewLessonDetailsService viewLessonDetailsService;

	@GetMapping("/{id}")
	public ResponseEntity<LessonDetails> getLessonDetailsById(@PathVariable Long id) {
		LessonDetails lesson = viewLessonDetailsService.getLessonById(id);
		if (lesson != null) {
			return ResponseEntity.ok(lesson);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

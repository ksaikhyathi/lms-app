package com.jm.lms.studentms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.lms.studentms.model.LessonDetails;
import com.jm.lms.studentms.repository.ViewLessonDetailsRepository;

@Service
public class ViewLessonDetailsService {

	@Autowired
	private ViewLessonDetailsRepository viewLessonDetailsRepository;

	public LessonDetails getLessonById(Long id) {
		Optional<LessonDetails> lesson = viewLessonDetailsRepository.findById(id);
		return lesson.orElse(null);
	}

}

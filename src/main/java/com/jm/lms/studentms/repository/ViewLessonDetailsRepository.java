package com.jm.lms.studentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.lms.studentms.model.LessonDetails;

@Repository

public interface ViewLessonDetailsRepository extends JpaRepository<LessonDetails, Long>  {

}


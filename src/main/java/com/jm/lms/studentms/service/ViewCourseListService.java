package com.jm.lms.studentms.service;

import com.jm.lms.studentms.model.Course;
import com.jm.lms.studentms.repository.ViewCourseListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ViewCourseListService {
    @Autowired
    private ViewCourseListRepository repository;

    public List<Course> viewAllcourses() {
        List<Course> course = repository.findAll();
        log.info("Response from courses" + course);
        return course;
    }

    public Course addCourse(Course course) {
        Course courses = repository.save(course);
        return courses;
    }


}

package com.jm.lms.studentms.controller;


import com.jm.lms.studentms.model.Course;
import com.jm.lms.studentms.service.ViewCourseListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j

@RestController
@RequestMapping("api/v1/course")
public class ViewCourseListController {

    @Autowired
    private ViewCourseListService service;

    @GetMapping
    public ResponseEntity<List<Course>> viewAllcourses() {
        List<Course> course = service.viewAllcourses();
        log.info("Request to get all courses" + course);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        log.info("request to add the courses" + course);
        Course course1 = service.addCourse(course);
        return ResponseEntity.ok(course1);
    }


}

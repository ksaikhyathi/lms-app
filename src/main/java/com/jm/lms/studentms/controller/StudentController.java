package com.jm.lms.studentms.controller;

import com.jm.lms.studentms.model.Student;
import com.jm.lms.studentms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/lms/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student newStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(newStudent);
    }


    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/find/id/{studentId}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable("studentId") Long id) {
        Optional<Student> student = studentService.findStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudentById(@RequestBody Student student, @PathVariable("studentId") Long id) {
        Student updated = studentService.updateStudentById(student, id);
        return ResponseEntity.accepted().body(updated);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("studentId") Long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping(value = "/find/firstName/{studentName}")
    public ResponseEntity<Optional<Student>> findStudentByName(@PathVariable("studentName") String firstName) {
        Optional<Student> student = studentService.findStudentByFirstName(firstName);
        return ResponseEntity.ok(student);
    }
}
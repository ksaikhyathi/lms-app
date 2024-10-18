package com.jm.lms.studentms.service;

import com.jm.lms.studentms.model.Student;
import com.jm.lms.studentms.repository.StudentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        List<Student> students = (List<Student>) studentRepository.findAll();
        return students;
    }

    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }

    @Transactional
    public Student updateStudentById(Student student, Long id) {
        Student updateStudent = new Student();

        Optional<Student> studentDB = studentRepository.findStudentById(id);

        if (StringUtils.isNotBlank(student.getFirstName())
                && !Objects.equals(student.getFirstName(), studentDB.get().getFirstName())) {
            updateStudent.setFirstName(student.getFirstName());
        } else {
            updateStudent.setFirstName(studentDB.get().getFirstName());
        }
        if (StringUtils.isNotBlank(student.getLastName())
                && !Objects.equals(student.getLastName(), studentDB.get().getLastName())) {
            updateStudent.setLastName(student.getLastName());
        } else {
            updateStudent.setLastName(studentDB.get().getLastName());
        }
        if (student.getDateOfBirth() != null
                && !Objects.equals(student.getDateOfBirth(), studentDB.get().getDateOfBirth())) {
            updateStudent.setDateOfBirth(student.getDateOfBirth());
        } else {
            updateStudent.setDateOfBirth(studentDB.get().getDateOfBirth());
        }
        if (StringUtils.isNotBlank(student.getEmail())
                && !Objects.equals(student.getEmail(), studentDB.get().getEmail())) {
            updateStudent.setEmail(student.getEmail());
        } else {
            updateStudent.setEmail(studentDB.get().getEmail());
        }
        updateStudent.setId(id);
        return studentRepository.save(updateStudent);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
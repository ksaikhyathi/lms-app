package com.jm.lms.studentms.service;

import com.jm.lms.studentms.exception.StudentNotFoundException;
import com.jm.lms.studentms.model.Student;
import com.jm.lms.studentms.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
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
        Optional<Student> checkIfStudentWithIdExist = studentRepository.findById(id);
        if (checkIfStudentWithIdExist.isEmpty()) {
            throw new StudentNotFoundException("Student can not find with id: " + id + " does not exist.");
        }
        return studentRepository.findStudentById(id);
    }

    public Optional<Student> findStudentByFirstName(String firstName) {
        Optional<Student> checkIfStudentWithIdExist = studentRepository.findStudentByFirstName(firstName);
        if (checkIfStudentWithIdExist.isEmpty()) {
            throw new StudentNotFoundException("Student can not find with firstName: " + firstName + " does not exist.");
        }
        return studentRepository.findStudentByFirstName(firstName);
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
        Optional<Student> checkIfStudentWithIdExist = studentRepository.findById(id);
        if (checkIfStudentWithIdExist.isEmpty()) {
            throw new StudentNotFoundException("Student can not be deleted because student with id: " + id + " does not exist.");
        }
        studentRepository.deleteById(id);
    }
}
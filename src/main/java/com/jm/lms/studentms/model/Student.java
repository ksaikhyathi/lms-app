package com.jm.lms.studentms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.crypto.Mac;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_student")
    @GenericGenerator(name = "seq_student", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "first name cant be empty or null")
    @Size(max = 8, min = 2, message = "first name must be between 2 and 8 characters")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Email(message = "Email must be valid")
    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "mobile_number")
    private String mobileNumber;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, LocalDate dateOfBirth, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\nFirst name: " + firstName + "\nLast name: " + lastName + "\nDate of Birth: "
                + dateOfBirth;
    }

}
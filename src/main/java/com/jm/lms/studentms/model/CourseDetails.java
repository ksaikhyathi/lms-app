package com.jm.lms.studentms.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Data
@Entity
@Table(name="coursedetails")
public class CourseDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_coursedetails")
	@GenericGenerator(name="seq_coursedetails", strategy="increment")
	@Column(name="id")
	private Long id;
	@Column(name="course_name")
	private String courseName;
	@Column(name="course_description")
	private String courseDescription;
	@Column(name="course_instructor")
	private String courseInstructor;
}

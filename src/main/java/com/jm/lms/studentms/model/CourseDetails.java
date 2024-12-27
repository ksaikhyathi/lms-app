package com.jm.lms.studentms.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "coursedetails")
public class CourseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_coursedetails")
	@GenericGenerator(name = "seq_coursedetails", strategy = "increment")
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "Course name is mandatory")
	@Size(min = 3, max = 50, message = "Course name must be between 3 and 50 characters")
	@Column(name = "course_name")
	private String courseName;

	@NotBlank(message = "Course description is mandatory")
	@Size(max = 100, message = "Course description cannot exceed 100 characters")
	@Column(name = "course_description")
	private String courseDescription;

	@NotBlank(message = "Course instructor is mandatory")
	@Size(min = 3, max = 10, message = "Course instructor name must be between 3 and 10 characters")
	@Column(name = "course_instructor")
	private String courseInstructor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public CourseDetails() {
		super();

	}

	public CourseDetails(Long id, String courseName, String courseDescription, String courseInstructor) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseInstructor = courseInstructor;
	}

	@Override
	public String toString() {
		return "CourseDetails [id=" + id + ", courseName=" + courseName + ", courseDescription=" + courseDescription
				+ ", courseInstructor=" + courseInstructor + "]";
	}
}

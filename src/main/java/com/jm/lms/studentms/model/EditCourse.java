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
import lombok.Data;

@Data
@Entity
@Table(name = "COURSE_DETAILS")

public class EditCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edit_course")
	@GenericGenerator(name = "edit_course", strategy = "increment")

	@Column(name = "id")
	private Long id;

	@NotBlank(message = "course name cant be empty or null")
	@Column(name = "course_name")
	private String courseName;

	@Column(name = "course_duriation")
	private String courseDuriation;
	
	@Column(name = "course_price")
	private Long coursePrice;

	
}

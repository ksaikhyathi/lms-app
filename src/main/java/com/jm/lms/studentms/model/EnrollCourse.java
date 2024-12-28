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
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Data
@Entity
@Table(name = "ENROLLCOURSE")
public class EnrollCourse {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_enrollcourse")
	    @GenericGenerator(name = "seq_enrollcourse", strategy = "increment")
	    @Column(name = "id")
	    private Long id;
	 
	 @NotBlank(message = "course name cant be empty or null")
	 @Size(max = 10, min = 3, message = "course name must be between 3 and 10 characters")
	 @Column(name = "course_name")
	    private String courseName;
	 
	 @NotBlank(message = "course username cant be empty or null")
	 @Column(name = "course_username")  
	    private String courseUserName;
	 

	 @Column(name = "course_password")   
	    private String coursePassword;
	 
	 @Column(name = "course_duration")
	    private String courseDuration;
		public Long getId() {
			return id;
		}

	}


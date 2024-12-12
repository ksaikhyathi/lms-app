package com.jm.lms.studentms.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Data
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_course")
    @GenericGenerator(name = "seq_course", strategy = "increment")
    @Column(name = "id", nullable = false)
	private Long id;
    @Column(name = "course_name", nullable = false)
	private String Name;
    @Column(name = "course_duration", nullable = false)
	private String duration;
    @Column(name = "course_fee", nullable = false)
	private double fee;
    
    
	
}

package com.jm.lms.studentms.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public Course(Long id, String name, String duration, double fee) {
		super();
		this.id = id;
		Name = name;
		this.duration = duration;
		this.fee = fee;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Course [" + (id != null ? "id=" + id + ", " : "") + (Name != null ? "Name=" + Name + ", " : "")
				+ (duration != null ? "duration=" + duration + ", " : "") + "fee=" + fee + "]";
	}
    
    

}

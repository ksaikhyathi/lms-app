package com.jm.lms.studentms.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lessondetails")
public class LessonDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lessondetails")
	@GenericGenerator(name = "seq_lessondetails", strategy = "increment")
	@Column(name = "id")
	private Long id;
	@Column(name = "lesson_name")
	private String lessonName;
	@Column(name = "lesson_description")
	private String lessonDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getLessonDescription() {
		return lessonDescription;
	}

	public void setLessonDescription(String lessonDescription) {
		this.lessonDescription = lessonDescription;
	}

	public LessonDetails(Long id, String lessonName, String lessonDescription) {
		super();
		this.id = id;
		this.lessonName = lessonName;
		this.lessonDescription = lessonDescription;
	}

	public LessonDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LessonDetails [id=" + id + ", lessonName=" + lessonName + ", lessonDescription=" + lessonDescription
				+ "]";
	}

}

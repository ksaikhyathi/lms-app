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
@Table(name = "ASSESSMENT")
public class Assessment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_assessment")
	@GenericGenerator(name = "seq_assessment", strategy = "increment")

	@Column(name = "id")
	private Long id;

	@NotBlank(message = "Student name should not be empty or null")
	@Column(name = "student_name")
	private String studentName;

	@NotBlank(message = "Assessment title should not be empty or null")
	@Column(name = "assessment_title")
	private String assessmentTitle;

	@NotBlank(message = "Assessment duration should be mandatory. Duration should not exceed 45 Minutes")
	@Column(name = "assessment_duration")
	private String assessmentDuration;

	@NotBlank(message = "Submitted Name should be mandatory")
	@Column(name = "assessment_submittedby")
	private String assessmentSubmittedby;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAssessmentTitle() {
		return assessmentTitle;
	}

	public void setAssessmentTitle(String assessmentTitle) {
		this.assessmentTitle = assessmentTitle;
	}

	public String getAssessmentDuration() {
		return assessmentDuration;
	}

	public void setAssessmentDuration(String assessmentDuration) {
		this.assessmentDuration = assessmentDuration;
	}

	public String getAssessmentSubmittedby() {
		return assessmentSubmittedby;
	}

	public void setAssessmentSubmittedby(String assessmentSubmittedby) {
		this.assessmentSubmittedby = assessmentSubmittedby;
	}

	public Assessment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Assessment(Long id, String studentName, String assessmentTitle, String assessmentDuration,
			String assessmentSubmittedby) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.assessmentTitle = assessmentTitle;
		this.assessmentDuration = assessmentDuration;
		this.assessmentSubmittedby = assessmentSubmittedby;
	}

	@Override
	public String toString() {
		return "Assessment [id=" + id + ", studentName=" + studentName + ", assessmentTitle=" + assessmentTitle
				+ ", assessmentDuration=" + assessmentDuration + ", assessmentSubmittedby=" + assessmentSubmittedby
				+ "]";
	}

}

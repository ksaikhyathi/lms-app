package com.jm.lms.studentms.model;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "topic_List")
public class TopicList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_topic")
	@GenericGenerator(name = "seq_topic", strategy = "increment")
	@Column(name = "id")
	private Long id;
	@Column(name = "topic_categeory")
	private String topicCategeory;
	@Column(name = "topic_title")
	private String topicTitle;
	@Column(name = "topic_concept")
	private String topicConcept;
	@Column(name = "topic_status")
	private String topicStatus;
	@Column(name = "starting_date")
	private LocalDate startingDate;
	@Column(name = "completion_date")
	private LocalDate completionDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTopicCategeory() {
		return topicCategeory;
	}
	public void setTopicCategeory(String topicCategeory) {
		this.topicCategeory = topicCategeory;
	}
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	public String getTopicConcept() {
		return topicConcept;
	}
	public void setTopicConcept(String topicConcept) {
		this.topicConcept = topicConcept;
	}
	public String getTopicStatus() {
		return topicStatus;
	}
	public void setTopicStatus(String topicStatus) {
		this.topicStatus = topicStatus;
	}
	public LocalDate getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}
	public LocalDate getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}
	public TopicList(Long id, String topicCategeory, String topicTitle, String topicConcept, String topicStatus,
			LocalDate startingDate, LocalDate completionDate) {
		super();
		this.id = id;
		this.topicCategeory = topicCategeory;
		this.topicTitle = topicTitle;
		this.topicConcept = topicConcept;
		this.topicStatus = topicStatus;
		this.startingDate = startingDate;
		this.completionDate = completionDate;
	}
	public TopicList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "TopicList [id=" + id + ", topicCategeory=" + topicCategeory + ", topicTitle=" + topicTitle
				+ ", topicConcept=" + topicConcept + ", topicStatus=" + topicStatus + ", startingDate=" + startingDate
				+ ", completionDate=" + completionDate + "]";
	}
			
	
}

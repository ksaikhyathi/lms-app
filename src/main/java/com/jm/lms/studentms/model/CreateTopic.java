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
@Table(name = "Topics")
public class CreateTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_topic")
	@GenericGenerator(name = "seq_topic", strategy = "increment")
	@Column(name = "id")
	private Long topicId;
	@Column(name = "topic_name")
	private String topicName;
	@Column(name = "topic_author")
	private String topicAuthor;
	@Column(name = "topic_description")
	private String topicDescription;
	@Column(name = "topic_status")
	private String topicStatus;

}

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
@Table(name = "Topics")
public class CreateTopic {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_topic")
	@GenericGenerator(name = "seq_topic", strategy = "increment")
	@Column(name = "id")
	private Long topicId;
	
	@NotBlank(message = "Topic name should not be blank or empty")
	@Size(min = 2, max = 10, message = "Topic name should be within the 2 to 10 characters")
	@Column(name = "topic_name")
	private String topicName;
	
	@NotBlank(message = "The author name of the topic should not be null or empty")
	@Size(min = 3, max = 20, message = "The author name should be between the 3 and 15 characters")
	@Column(name = "topic_author")
	private String topicAuthor;
	
	@NotBlank(message = "The description of topic cannot be empty or null")
	@Column(name = "topic_description")
	private String topicDescription;
	
	@Column(name = "topic_status")
	private String topicStatus;

}

package com.jm.lms.studentms.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.lms.studentms.model.CreateTopic;
import com.jm.lms.studentms.service.CreateTopicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/lms/topics")
public class CreateTopicController {
	@Autowired
	private CreateTopicService createTopicService;
	
	@PostMapping("/addTopic")
	public ResponseEntity<CreateTopic> addTopic(@RequestBody CreateTopic topic){
		log.info("Posting data into the database. {}", topic);
		CreateTopic topics = createTopicService.addTopic(topic);
		log.info("Posted the data into database.CreateTopic:{}", topics);
		return ResponseEntity.ok(topics);
	}
	@GetMapping("/getAllTopics")
	public ResponseEntity<List<CreateTopic>> getAllTopics(){
		log.info("Retrieving data from the database");
		List<CreateTopic> topics = createTopicService.getAllTopics();
		log.info("Retrieved {} data from the database", topics);
		return ResponseEntity.ok(topics);
	}
	@GetMapping("/find/by/{id}")
	public ResponseEntity<Optional<CreateTopic>> findTopicById(@PathVariable("id") Long id){
		log.info("Retrieving data by id.", id);
		Optional<CreateTopic> topic = createTopicService.findTopicById(id);
		log.info("Retrieved data by id.", topic);
		return ResponseEntity.ok(topic);
	}
	@PutMapping("/updateTopic")
	public ResponseEntity<CreateTopic> updateTopics(@RequestBody CreateTopic topic){
		log.info("Updating topics in the database: {}", topic);
		CreateTopic updatedTopic = createTopicService.updateTopics(topic);
		log.info("Updated topic in the database: {}",updatedTopic);
		return ResponseEntity.ok(updatedTopic);
	}
	@PutMapping("/updateTopic/{id}")
	public CreateTopic updateTopicById(@PathVariable("id") Long id, @RequestBody CreateTopic topic) {
		log.info("Updating details by id: {}", topic);
		return createTopicService.updateTopicById(id, topic);
	}
	@PatchMapping("/update/{id}")
	public CreateTopic updateTopicByFields(@PathVariable("id") Long id, @RequestBody Map<String, Object> fields) {
		log.info("Updating topic fields in the database.", id, fields);
		return createTopicService.updateTopicByFields(id, fields);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CreateTopic> deleteTopicById(@PathVariable("id") Long id){
		log.info("Deleting the data from the database.", id);
		createTopicService.deleteTopicById(id);
		log.info("Deleted the data from the database.", id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}

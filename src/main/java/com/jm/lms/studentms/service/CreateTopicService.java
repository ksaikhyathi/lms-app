package com.jm.lms.studentms.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.jm.lms.studentms.model.CreateTopic;
import com.jm.lms.studentms.repository.CreateTopicRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CreateTopicService {
	@Autowired
	private CreateTopicRepository createTopicRepository;

	public CreateTopic addTopic(CreateTopic topic) {
		CreateTopic topics = createTopicRepository.save(topic);
		log.info("Saving the topic: {}", topic);
		return topics;
	}

	public List<CreateTopic> getAllTopics() {
		List<CreateTopic> topics = createTopicRepository.findAll();
		log.info("Getting all the topics.");
		return topics;
	}

	public Optional<CreateTopic> findTopicById(Long id) {
		Optional<CreateTopic> topic = createTopicRepository.findById(id);
		log.info("Getting topic by id:{}", topic);
		return topic;
	}

	public CreateTopic updateTopics(CreateTopic topic) {
		CreateTopic updatedTopic = createTopicRepository.save(topic);
		log.info("Updating the topic:{}", updatedTopic);
		return updatedTopic;
	}

	public CreateTopic updateTopicById(Long id, CreateTopic topic) {
		Optional<CreateTopic> existingTopic = createTopicRepository.findById(id);
		if(existingTopic.isPresent()) {
			existingTopic.get().setTopicName(topic.getTopicName());
			existingTopic.get().setTopicAuthor(topic.getTopicAuthor());
			existingTopic.get().setTopicDescription(topic.getTopicDescription());
			existingTopic.get().setTopicStatus(topic.getTopicStatus());
			log.info("Updating topic by id:{}", existingTopic);
			return createTopicRepository.save(existingTopic.get());
		}
		return null;
	}

	public CreateTopic updateTopicByFields(Long id, Map<String, Object> fields) {
		Optional<CreateTopic> existingTopic = createTopicRepository.findById(id);
		if(existingTopic.isPresent()) {
			fields.forEach((key, val)->{
				Field field = ReflectionUtils.findField(CreateTopic.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingTopic.get(), val);
				log.info("Updating topic fields by id:{}",existingTopic);
			});
			return createTopicRepository.save(existingTopic.get());
		}
		return null;
	}

	public void deleteTopicById(Long id) {
		createTopicRepository.deleteById(id);
		log.info("Deleted the topic.");
	}
}

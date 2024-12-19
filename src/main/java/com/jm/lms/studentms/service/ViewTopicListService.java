package com.jm.lms.studentms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.lms.studentms.model.Student;
import com.jm.lms.studentms.model.TopicList;
import com.jm.lms.studentms.repository.TopicListRespository;

@Service
public class ViewTopicListService {

	@Autowired
	private ViewTopicListRespository topicListRepository;

	public Optional<TopicList> getTopicListByTitle(String topicTitle) {
		return topicListRepository.findByTopicTitle(topicTitle);
	}

	public List<TopicList> getAllTopics() {
		List<TopicList> all = topicListRepository.findAll();
		System.out.println("all topics"+all);
		return all;
		
	}

	public TopicList saveTopic(TopicList topicList) {
		return topicListRepository.save(topicList);
	}

	public TopicList updateTopicByTitle(TopicList topicList, String topicTitle) {
		Optional<TopicList> existingTopic = topicListRepository.findByTopicTitle(topicTitle);
		if (existingTopic.isPresent()) {

			existingTopic.get().setTopicCategeory(topicList.getTopicCategeory());
			existingTopic.get().setTopicTitle(topicList.getTopicTitle());
			existingTopic.get().setTopicConcept(topicList.getTopicConcept());
			existingTopic.get().setStartingDate(topicList.getStartingDate());
			existingTopic.get().setCompletionDate(topicList.getCompletionDate());
			existingTopic.get().setTopicStatus(topicList.getTopicStatus());

			return topicListRepository.save(existingTopic.get());

		}
		return null;
	}

}

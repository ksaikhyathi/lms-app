package com.jm.lms.studentms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.lms.studentms.model.TopicList;

@Repository
public interface ViewTopicListRespository extends JpaRepository<TopicList,Long> {
	
	Optional<TopicList> findByTopicTitle(String topicTitle);

}

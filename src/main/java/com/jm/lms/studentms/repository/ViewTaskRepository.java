package com.jm.lms.studentms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.lms.studentms.model.TaskDetails;
import java.util.List;


@Repository
public interface ViewTaskRepository extends JpaRepository<TaskDetails, Long> {

	Optional<TaskDetails> findTaskById(Long id);

	Optional<TaskDetails> findByTaskName(String taskName);

	Optional<TaskDetails> getTaskByCreatedBy(String createdBy);
	
    List<TaskDetails> findByTaskStatus(String task);
}

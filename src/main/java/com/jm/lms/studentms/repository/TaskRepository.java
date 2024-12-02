package com.jm.lms.studentms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.lms.studentms.model.Task;
import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	Optional<Task> getTaskById(Long id);

	Optional<Task> findByTaskName(String taskName);

	Optional<Task> getTaskByCreatedBy(String createdBy);
	
    List<Task> findByTaskStatus(String task);
}

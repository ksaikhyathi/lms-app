package com.jm.lms.studentms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jm.lms.studentms.model.TaskDetails;
import com.jm.lms.studentms.repository.ViewTaskRepository;

@Service
public class ViewTaskService {
    
	@Autowired
	private ViewTaskRepository viewTaskRepository;
	
	public ViewTaskService(ViewTaskRepository viewTaskRepository) {
	      this.viewTaskRepository = viewTaskRepository;
	}

	public List<TaskDetails> getAllTasks() {
		List<TaskDetails> task = viewTaskRepository.findAll();
		System.out.println(task);
		return task;
	}

	public Optional<TaskDetails> findTaskById(Long id) {
		Optional<TaskDetails> task =viewTaskRepository.findTaskById(id);
		System.out.println(task);
		return task;
	}

	public Optional<TaskDetails> findByTaskName(String taskName) {
		Optional<TaskDetails> task =viewTaskRepository.findByTaskName(taskName);
		System.out.println(task);
		return task;
	}

	public Optional<TaskDetails> getTaskByCreatedBy(String createdBy) {
		Optional<TaskDetails> task = viewTaskRepository.getTaskByCreatedBy(createdBy);
		System.out.println(task);
		return task;
	}

	public List<TaskDetails> findTaskByTaskStatus(String task) {
		List<TaskDetails> tasks = viewTaskRepository.findByTaskStatus(task);
		System.out.println(tasks);
		return tasks;
	}
}


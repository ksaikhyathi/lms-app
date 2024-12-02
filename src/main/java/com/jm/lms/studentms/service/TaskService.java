package com.jm.lms.studentms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jm.lms.studentms.model.Task;
import com.jm.lms.studentms.repository.TaskRepository;

@Service
public class TaskService {
    
	@Autowired
	private TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
	      this.taskRepository = taskRepository;
	}

	public List<Task> getAllTasks() {
		List<Task> task = taskRepository.findAll();
		System.out.println(task);
		return task;
	}

	public Optional<Task> getTaskById(Long id) {
		Optional<Task> task =taskRepository.getTaskById(id);
		System.out.println(task);
		return task;
	}

	public Optional<Task> findByTaskName(String taskName) {
		Optional<Task> task =taskRepository.findByTaskName(taskName);
		System.out.println(task);
		return task;
	}

	public Optional<Task> getTaskByCreatedBy(String createdBy) {
		Optional<Task> task = taskRepository.getTaskByCreatedBy(createdBy);
		System.out.println(task);
		return task;
	}

	public List<Task> getTaskByTaskStatus(String task) {
		List<Task> tasks = taskRepository.findByTaskStatus(task);
		System.out.println(tasks);
		return tasks;
	}
}


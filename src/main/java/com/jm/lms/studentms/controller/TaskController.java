package com.jm.lms.studentms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jm.lms.studentms.model.Task;
import com.jm.lms.studentms.service.TaskService;

@RestController
@RequestMapping("/api/v1/lms/task/")
public class TaskController {
	
	  private final TaskService taskService;

	   @Autowired
	   public TaskController(TaskService taskService) {
	        this.taskService = taskService;
	   }
	   
	   @GetMapping("/view")
	    public List<Task> getAllTasks() {
	        return taskService.getAllTasks();
	   } 
	   
	   @GetMapping("/viewById/{id}")
	   public ResponseEntity<Optional<Task>> getTaskById(@PathVariable("id") Long id) {
		   Optional<Task> task = taskService.getTaskById(id);
		       return ResponseEntity.ok(task);
	   }
	   
	   @GetMapping("viewByName/{name}")
	   public ResponseEntity<Optional<Task>>findByTaskName(@PathVariable("name") String taskName){
		   Optional<Task> task = taskService.findByTaskName(taskName);
		      return ResponseEntity.ok(task);
	   }
	   
	   @GetMapping("viewByCreatedName/{createdby}")
	   public ResponseEntity<Optional<Task>> getTaskByCreatedBy(@PathVariable("createdby") String createdBy){
		   Optional<Task> task = taskService.getTaskByCreatedBy(createdBy);
		      return ResponseEntity.ok(task);
	   }
	   
	   @GetMapping("viewByStatus/{status}")
	   public List<Task> getTaskByTaskStatus(@PathVariable("status") String taskStatus) {
	        return taskService.getTaskByTaskStatus(taskStatus);
	   } 
	   
	   
}

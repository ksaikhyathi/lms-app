package com.jm.lms.studentms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jm.lms.studentms.model.TaskDetails;
import com.jm.lms.studentms.service.ViewTaskService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/lms/task/")
public class ViewTaskController {
	
	  private final ViewTaskService viewTaskService;

	   @Autowired
	   public ViewTaskController(ViewTaskService viewTaskService) {
	        this.viewTaskService = viewTaskService;
	   }
	   
	   @GetMapping("/view")
	    public List<TaskDetails> getAllTasks(@Valid TaskDetails taskDetails) {
		   log.info("Entering getAllTasks method");
	        List<TaskDetails> tasks = viewTaskService.getAllTasks();
	        if (tasks.isEmpty()) {
	            log.warn("No tasks is found");
	        } else {
	            log.info("Successfully viwed tasks");
	        }
	        return tasks;
	   } 
	   
	   @GetMapping("/viewById/{id}")
	   public ResponseEntity<TaskDetails> findTaskById(@PathVariable("id") Long id) {
		    log.info("Received request to view task by ID: {}", id);
	        Optional<TaskDetails> task = viewTaskService.findTaskById(id);
	        if (task.isPresent()) {
	            log.info("Task viewed with ID: {}", id);
	            return ResponseEntity.ok(task.get());
	        } else {
	            log.warn("No task found with ID: {}", id);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	   }
	   
	   @GetMapping("viewByName/{name}")
	   public ResponseEntity<TaskDetails> findByTaskName(@PathVariable("name") String taskName){
		   log.info("Received request to view task by name: {}", taskName);
	        Optional<TaskDetails> task = viewTaskService.findByTaskName(taskName);
	        if (task.isPresent()) {
	            log.info("Task viwed with name: {}", taskName);
	            return ResponseEntity.ok(task.get());
	        } else {
	            log.warn("No task found with name: {}", taskName);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	   }
	   
	   @GetMapping("viewByCreatedName/{createdby}")
	   public ResponseEntity<Optional<TaskDetails>> getTaskByCreatedBy(@PathVariable("createdby") String createdBy){
		   log.info("Received request to get task by created by: {}", createdBy);
	        Optional<TaskDetails> task = viewTaskService.getTaskByCreatedBy(createdBy);
	        if (task.isPresent()) {
	            log.info("Task found with created by: {}", createdBy);
	            return ResponseEntity.ok(task);
	        } else {
	            log.warn("No task found with  created by: {}", createdBy);
	            return ResponseEntity.notFound().build();
	        }
	   }
	   
	   @GetMapping("viewByStatus/{status}")
	   public List<TaskDetails> findTaskByTaskStatus(@PathVariable("status") String taskStatus) {
		   log.info("Received request to view tasks with status: {}", taskStatus);
		   List<TaskDetails> tasks = viewTaskService.findTaskByTaskStatus(taskStatus);
	        if (tasks.isEmpty()) {
	            log.warn("No tasks found with status: {}", taskStatus);
	        } else {
	            log.info("Task Found with status: {}", taskStatus);
	        }
	        return tasks;
	    }
}

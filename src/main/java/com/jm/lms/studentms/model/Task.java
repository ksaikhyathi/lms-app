package com.jm.lms.studentms.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
	 @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_student")
	    @GenericGenerator(name = "seq_student", strategy = "increment")
	    @Column(name = "id" , nullable=false)
	    private Long id;
		@Column(name = "task_name" , nullable=false)
	    private String taskName;
	    @Column(name = "created_by" , nullable=false)
	    private String createdBy;
	    @Column(name = "task_status" , nullable = false)
	    private String taskStatus;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTaskName() {
			return taskName;
		}
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getTaskStatus() {
			return taskStatus;
		}
		public void setTaskStatus(String taskStatus) {
			this.taskStatus = taskStatus;
		}
		@Override
		public String toString() {
			return "Task [id=" + id + ", taskName=" + taskName + ", createdBy=" + createdBy + ", taskStatus="
					+ taskStatus + "]";
		}
		public Task(Long id, String taskName, String createdBy, String taskStatus) {
			super();
			this.id = id;
			this.taskName = taskName;
			this.createdBy = createdBy;
			this.taskStatus = taskStatus;
		}
		public Task() {
			
		}
	    
	    
	     
	     
	
	     
	     
	    
	     
}

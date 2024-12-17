package com.jm.lms.studentms.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "taskdetails")
public class TaskDetails {
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
}

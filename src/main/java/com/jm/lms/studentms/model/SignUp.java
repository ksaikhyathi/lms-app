package com.jm.lms.studentms.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "signup")
public class SignUp {
		
		    @Id
		    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_signup")
		    @GenericGenerator(name = "seq_signup", strategy = "increment")
		    @Column(name = "id")
		    private Long id;

		    @Column(name = "username")
		    private String username;

		    @Column(name = "password")
		    private String password;

		    @Column(name = "email")
		    private String email;

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public SignUp() {
				super();
				// TODO Auto-generated constructor stub
			}

			public SignUp(Long id, String username, String password, String email) {
				super();
				this.id = id;
				this.username = username;
				this.password = password;
				this.email = email;
			}

			@Override
			public String toString() {
				return "SignUp [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
			}
			

		


	}



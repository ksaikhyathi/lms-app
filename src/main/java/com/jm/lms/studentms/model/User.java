package com.jm.lms.studentms.model;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@GenericGenerator(name = "seq", strategy = "increment")
	@Column(name = "Id")
	private Long id;
	@Column(name = "User_Name", nullable = false)
	private String userName;
	@Column(name = "Password", nullable = false, unique = true)
	private String password;
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	@Column(name = "Phone_Number", nullable = false, unique = true, length = 10)
	private String contact;
	@Column(name = "job_Role")
	private String role;
	@Column(name = "Date_Of_Birth")
	private LocalDate dateOfBirth;
	@Column(name = "Gender")
	private String gender;
	@Column(name = "User_Address")
	private String address;

	public User() {

	}

	public User(Long id, String userName, String password, String email, String contact, String role,
			LocalDate dateOfBirth, String gender, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.contact = contact;
		this.role = role;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName.toUpperCase();
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role.toUpperCase();
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender.toUpperCase();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address.toUpperCase();
	}

	@Override
	public String toString() {
		return "<---User Deatails--->\nId: " + id + "\nUserName: " + userName + "\nEmail: " + email
				+ "\nContact: " + contact + "\nRole: " + role + "\nDateOfBirth: " + dateOfBirth + "\nGender: " + gender
				+ "\nAddress: " + address;
	}

}

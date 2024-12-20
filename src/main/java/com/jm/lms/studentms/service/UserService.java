package com.jm.lms.studentms.service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.jm.lms.studentms.model.User;
import com.jm.lms.studentms.repository.UserRepository;

@Service

public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		User user1 = userRepository.save(user);
		System.out.println(user1);
		return user1;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public Optional<User> findByName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public Optional<User> findByContact(String contact) {
		return userRepository.findByContact(contact);
	}

	public List<User> findByRole(String role) {
		return userRepository.findByRole(role);
	}

	public List<User> findByDOB(LocalDate DOB) {
		return userRepository.findByDateOfBirth(DOB);

	}

	public List<User> findByGender(String gender) {
		return userRepository.findByGender(gender);
	}

	public List<User> findByAddress(String address) {
		return userRepository.findByAddress(address);
	}

	public Boolean loginUserWithEmailAndPassword(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return user != null;
	}

	public Boolean loginUserWithIdAndPassword(Long id, String password) {
		User user = userRepository.findByIdAndPassword(id, password);
		return user != null;
	}

	public User updateUserById(User user) {
		return userRepository.save(user);

	}

	public User updateFeildsById(Long id, Map<String, Object> data) {
		Optional<User> user = userRepository.findById(id);
//		for (Map. entry : data.entrySet()) {
//			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
//		}

		if (user.isPresent()) {
			
			data.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(User.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, user.get(), value);

			});
			System.out.println("Response: " + user.get());
			return userRepository.save(user.get());
		}

		return null;
	}

	public Boolean deleteById(Long id) {
		Optional<User> user = userRepository.findById(id);
		System.out.println(user);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Boolean deleteUserByEmailAndPassword(String email,String password) {
		User user=userRepository.findByEmailAndPassword(email, password);
		if(user!=null) {
			userRepository.delete(user);
			return true;
		}
		return false;	
	}

	public Boolean deleteUserByIdAndPassword(Long id, String password) {
		User user=userRepository.findByIdAndPassword(id, password);
		if(user!=null) {
			userRepository.delete(user);
			return true;
		}
		return false;
	}	
	
	public Boolean deleteAllUsers() {
		List<User> allUsers=userRepository.findAll();
		if(!(allUsers.isEmpty())) {
			userRepository.deleteAll();	
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
}

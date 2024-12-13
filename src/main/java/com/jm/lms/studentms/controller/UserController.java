package com.jm.lms.studentms.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jm.lms.studentms.model.User;
import com.jm.lms.studentms.service.UserService;

@RestController
@RequestMapping("api/v2/lms/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		System.out.println(user);
		return ResponseEntity.ok(userService.addUser(user));
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}

	@GetMapping("/getUserByUserName/{userName}")
	public ResponseEntity<Optional<User>> getUserByName(@PathVariable("userName") String userName) {
		return ResponseEntity.ok(userService.findByName(userName));
	}

	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable("email") String email) {
		return ResponseEntity.ok(userService.findByEmail(email));
	}

	@GetMapping("/getUserByContact/{contact}")
	public ResponseEntity<Optional<User>> getUserByContact(@PathVariable("contact") String contact) {
		return ResponseEntity.ok(userService.findByContact(contact));
	}

	@GetMapping("/getUserByRole/{role}")
	public ResponseEntity<List<User>> getUsersByRole(@PathVariable("role") String role) {
		return ResponseEntity.ok(userService.findByRole(role));
	}

	@GetMapping("/getUserByDateOfBirth/{DOB}")
	public ResponseEntity<List<User>> getUsersByDOB(@PathVariable("DOB") LocalDate DOB) {
		return ResponseEntity.ok(userService.findByDOB(DOB));

	}

	@GetMapping("/getUserByGender/{gender}")
	public ResponseEntity<List<User>> getUsersByGender(@PathVariable("gender") String gender) {
		return ResponseEntity.ok(userService.findByGender(gender));
	}

	@GetMapping("/getUserByAddress/{address}")
	public ResponseEntity<List<User>> getUsersByAddress(@PathVariable("address") String address) {
		return ResponseEntity.ok(userService.findByAddress(address));
	}

	@GetMapping("/loginWithEmailAndPassWord")
	public String loginUserWithEmailAndPassword(@RequestParam String email, @RequestParam String password) {
		Boolean isLogin = userService.loginUserWithEmailAndPassword(email, password);
		if (isLogin) {
			System.out.println("***Login successfull***");
			Optional<User> user = userService.findByEmail(email);
			System.out.println(user.get());
			return "login successfull " + user.get().getUserName().toLowerCase();
		} else
			return "wrong credintials";
	}

	@GetMapping("/loginWithIdAndPassword/{id}")
	public String loginWithIdAndPassword(@PathVariable("id") Long id, @RequestParam String password) {
		Boolean isLogin = userService.loginUserWithIdAndPassword(id, password);
		if (isLogin) {
			System.out.println("***Login is successfull***");
			Optional<User> user = userService.findById(id);
			System.out.println(user.get());
			return "Login successfull " + user.get().getUserName().toLowerCase();
		} else
			System.out.println("Login is unsuccessfull");
			return "Login is Unsuccessfull";
	}

	@PutMapping("/updateUserById")
	public ResponseEntity<User> updateUserById(@RequestBody User user) {
		return ResponseEntity.ok(userService.updateUserById(user));
	}

	@PatchMapping("/updateFeildsOfUserDataById/{id}")
	public ResponseEntity<User> updateFeildsById(@PathVariable("id") Long id, @RequestBody Map<String, Object> data) {
		return ResponseEntity.ok(userService.updateFeildsById(id, data));
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		Boolean isPresent=userService.deleteById(id);

		if (isPresent) {
			return id + " is deleted ";
		}
		return id + " not present ";
	}
	
	@DeleteMapping("/deleteUserByEmailAndPassword")
	public String deleteUserByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
		Boolean isDeleted=userService.deleteUserByEmailAndPassword(email, password);
		if(isDeleted) {
			return "deleted";
		}		
		return "wrong credintials";
	}
	
	@DeleteMapping("/deleteUserByIdAndPassword/{id}")
	public String deleteUserByIdAndPassword(@PathVariable("id") Long id, @RequestParam String password) {
		Boolean isDeleted=userService.deleteUserByIdAndPassword(id, password);
		if(isDeleted) {
			return id+" is Deleted";
		} 
		return "wrong credintials";
	}
	
	@DeleteMapping("/deleteAllUsers")
	public String deleteAllUsers() {
		Boolean isPresent= userService.deleteAllUsers();
		if(isPresent) {
		return "All records are deleted";
		}
		return "No records found";	
	}
	
}

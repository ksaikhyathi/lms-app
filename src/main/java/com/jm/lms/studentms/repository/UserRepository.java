package com.jm.lms.studentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jm.lms.studentms.model.User;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAll();

	Optional<User> findById(Long id);

	Optional<User> findByUserName(String userName);

	Optional<User> findByEmail(String email);

	Optional<User> findByContact(String contact);

	List<User> findByRole(String role);

	List<User> findByDateOfBirth(LocalDate dateOfBirth);

	List<User> findByGender(String gender);

	List<User> findByAddress(String address);

	User findByEmailAndPassword(String email, String password);

	User findByIdAndPassword(Long id, String password);
	

}

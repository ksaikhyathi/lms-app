package com.jm.lms.studentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.lms.studentms.model.SignUp;

@Repository
public interface SignUpServiceRepository extends JpaRepository<SignUp, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
	




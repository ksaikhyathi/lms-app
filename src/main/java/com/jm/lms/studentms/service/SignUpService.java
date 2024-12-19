package com.jm.lms.studentms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jm.lms.studentms.model.SignUp;
import com.jm.lms.studentms.repository.SignUpServiceRepository;

@Service
public class SignUpService {

    @Autowired
    private SignUpServiceRepository signUpServiceRepository;

    public String signUp(SignUp signUp) {
    	
        if (signUpServiceRepository.existsByUsername(signUp.getUsername())) {
            return "Username already exists."; 
        }
        if (signUpServiceRepository.existsByEmail(signUp.getEmail())) {
            return "Email already exists."; 
        }
        signUpServiceRepository.save(signUp);

        return "User registered successfully.";
    }
}




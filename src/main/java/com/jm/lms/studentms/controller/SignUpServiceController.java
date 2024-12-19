package com.jm.lms.studentms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.lms.studentms.model.SignUp;
import com.jm.lms.studentms.service.SignUpService;

@RestController
@RequestMapping("api/v1/lms/signup")
public class SignUpServiceController {

@Autowired
private SignUpService signUpService;

@PostMapping("/adduser")
public ResponseEntity<String> signUp(@RequestBody SignUp signup) {
    String result = signUpService.signUp(signup); 

    if (result.equals("Username already exists.")) {
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    if (result.equals("Email already exists.")) {
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    return ResponseEntity.ok(result);
}
}

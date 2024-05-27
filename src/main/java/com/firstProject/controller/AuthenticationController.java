package com.firstProject.controller;

import com.firstProject.security.model.AuthenticationRequest;
import com.firstProject.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http:localhost:3000")

@RestController
@RequestMapping("authenticate")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/create")
    @CrossOrigin
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try{
            return ResponseEntity.ok(authenticationService.createAuthenticationToken(authenticationRequest));
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Incorrect Username Or Password");
        }
    }
}



package com.gabriel.authenticatebackend.controllers;

import com.gabriel.authenticatebackend.model.ApplicationUser;
import com.gabriel.authenticatebackend.model.DTO.RegistrationDTO;
import com.gabriel.authenticatebackend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ApplicationUser> registerUser(@RequestBody RegistrationDTO body) {
        ApplicationUser user = authenticationService.registerUser(body.username(), body.password());
        return ResponseEntity.ok().body(user);
    }
}

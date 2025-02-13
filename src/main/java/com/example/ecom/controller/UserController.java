package com.example.ecom.controller;

import com.example.ecom.dto.request.UserRegistrationRequest;
import com.example.ecom.dto.request.UserRequest;
import com.example.ecom.dto.response.UserResponse;
import com.example.ecom.service.UserService;
import com.example.ecom.util.ResponseStructure;
import com.example.ecom.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRegistrationRequest registrationRequest) {
        UserResponse response = userService.register(registrationRequest);
        return responseBuilder.success(HttpStatus.CREATED, "User registered successfully", response);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseStructure<UserResponse>> findByUserId(@PathVariable String id){
        UserResponse response = userService.findByUserId(id);
        return responseBuilder.success(HttpStatus.FOUND, "User found successfully", response);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateByUserId(@PathVariable String id, @RequestBody UserRequest userRequest) {
        UserResponse response = userService.updateByUserId(id, userRequest);
        return responseBuilder.success(HttpStatus.OK, "User updated successfully", response);
    }
}

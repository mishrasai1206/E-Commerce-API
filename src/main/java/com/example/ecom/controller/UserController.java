package com.example.ecom.controller;

import com.example.ecom.dto.request.UserRegistrationRequest;
import com.example.ecom.dto.request.UserRequest;
import com.example.ecom.dto.response.UserResponse;
import com.example.ecom.model.User;
import com.example.ecom.service.UserService;
import com.example.ecom.util.ResponseStructure;
import com.example.ecom.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register/customer")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRegistrationRequest registrationRequest) {
        UserResponse response = userService.register(registrationRequest);
        return responseBuilder.success(HttpStatus.CREATED, "User registered successfully", response);
    }
}

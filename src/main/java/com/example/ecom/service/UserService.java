package com.example.ecom.service;

import com.example.ecom.dto.request.UserRegistrationRequest;
import com.example.ecom.dto.request.UserRequest;
import com.example.ecom.dto.response.UserResponse;
import com.example.ecom.model.User;
import com.example.ecom.util.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public UserResponse register(UserRegistrationRequest registrationRequest);

    public UserResponse findByUserId(String id);

    public UserResponse updateByUserId(String id, UserRequest userRequest);
}

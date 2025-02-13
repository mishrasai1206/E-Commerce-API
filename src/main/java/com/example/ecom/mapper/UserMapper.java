package com.example.ecom.mapper;

import com.example.ecom.dto.request.UserRegistrationRequest;
import com.example.ecom.dto.request.UserRequest;
import com.example.ecom.dto.response.UserResponse;
import com.example.ecom.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    public UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .isDeleted(false)
                .createdAt(LocalDateTime.now())
                .lastModifiedBy(LocalDateTime.now())
                .build();
    }

    public void mapToUser(UserRegistrationRequest registrationRequest, User user) {
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setRole(registrationRequest.getUserRole());
        user.setPassword(registrationRequest.getPassword());
    }

    public void mapToUser(UserRequest userRequest, User user) {
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
    }
}

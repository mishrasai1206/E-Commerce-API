package com.example.ecom.dto.response;

import com.example.ecom.enums.UserRole;

import java.time.LocalDateTime;

public class UserResponse {
    private String id;
    private String username;
    private String email;
    private UserRole role;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedBy;
}

package com.example.ecom.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private String username;
    private String email;
}

package com.example.ecom.dto.response;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String title;
    private String description;
    private String category;
    private String imageLink;
    private int stock;
    private double price;
    private LocalDateTime createdBy;
    private LocalDateTime lastModifiedBy;

}

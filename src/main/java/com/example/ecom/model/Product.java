package com.example.ecom.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    private String category;
    private String imageLink;
    private int stock;
    private double price;

    @CreatedDate
    private LocalDateTime createdBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedBy;

    @ManyToOne
    private Seller seller;
}

package com.example.ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Seller extends User {

    @OneToMany(mappedBy = "seller")
    private List<Product> products;
}

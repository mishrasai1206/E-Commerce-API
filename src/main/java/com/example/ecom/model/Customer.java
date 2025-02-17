package com.example.ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Customer extends User{

    @OneToMany(mappedBy = "customer")
    private List<CartItem> cartItems;
}

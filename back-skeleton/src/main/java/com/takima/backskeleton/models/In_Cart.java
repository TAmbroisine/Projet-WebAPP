package com.takima.backskeleton.models;

import jakarta.persistence.*;

@Entity
@Table(name = "in_cart")
public class In_Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buy_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}

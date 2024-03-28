package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "Product")
@Getter
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "category")
    private String category;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<In_Cart> inCarts;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private Product(Product.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.inCarts = builder.inCarts;
        this.category = builder.category;
        this.seller = builder.seller;
    }
    public Product() {
    }

    public static class Builder {
        private Long id;
        private String name;
        private float price;
        private String category;
        private List<In_Cart> inCarts;

        private Seller seller;

        public Product.Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Product.Builder name(String name) {
            this.name = name;
            return this;
        }
        public Product.Builder price(float price) {
            this.price = price;
            return this;
        }

        public Product.Builder category(String category) {
            this.category = category;
            return this;
        }

        public Product.Builder inCarts(List<In_Cart> inCarts) {
            this.inCarts = inCarts;
            return this;
        }

        public Product.Builder seller(Seller seller){
            this.seller = seller;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}

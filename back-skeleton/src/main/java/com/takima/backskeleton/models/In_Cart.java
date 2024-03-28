package com.takima.backskeleton.models;

import com.takima.backskeleton.DTO.InCartDto;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "in_cart")
@Getter
public class In_Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buy_id")
    private Buyer buyer;

    @ManyToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;

    private In_Cart(Builder builder) {
        this.id = builder.id;
        this.products = builder.products;
        this.buyer = builder.buyer;
    }
    public In_Cart() {
    }

    public static class Builder {
        private Long id;
        private List<Product> products;
        private Buyer buyer;

        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Builder products(List<Product> products) {
            this.products = products;
            return this;
        }
        public Builder buyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }

        public In_Cart build() {
            return new In_Cart(this);
        }
    }

}

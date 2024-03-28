package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "buyer")
@Getter
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buy_id")
    private Long id;
    @Column(name = "fname")
    private String firstName;
    @Column(name = "lname")
    private String lastName;

    @Column(name="mail")
    private String email;

    @OneToMany(mappedBy = "buyer")
    private List<In_Cart> inCart;

    private Buyer(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.inCart = builder.inCart;
        this.email = builder.email;
    }
    public Buyer() {
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private List<In_Cart> inCart;

        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder inCart(List<In_Cart> inCart) {
            this.inCart = inCart;
            return this;
        }

        public Buyer build() {
            return new Buyer(this);
        }
    }
}

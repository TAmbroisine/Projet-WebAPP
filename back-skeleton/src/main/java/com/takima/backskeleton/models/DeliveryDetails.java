package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "delivery_details")
@Getter
public class DeliveryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    @Column(name="city")
    private String city;
    @Column(name="postal_code")
    private String postCode;
    @Column(name="country")
    private String country;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name = "fname")
    private String firstName;
    @Column(name = "lname")
    private String lastName;

    @ManyToOne(cascade = CascadeType.MERGE)
    @Column(name = "buy_id")
    private Buyer buyer;

    private DeliveryDetails(Builder deliveryDetails) {
        this.id = deliveryDetails.id;
        this.firstName = deliveryDetails.firstName;
        this.lastName = deliveryDetails.lastName;
        this.addressLine1 = deliveryDetails.addressLine1;
        this.addressLine2 = deliveryDetails.addressLine2;
        this.country = deliveryDetails.country;
        this.phoneNumber = deliveryDetails.phoneNumber;
        this.postCode = deliveryDetails.postCode;
        this.buyer = deliveryDetails.buyer;
        this.city = deliveryDetails.city;
    }

    public DeliveryDetails() {
    }

    public static class Builder {
        private Long id;
        private String addressLine1;
        private String addressLine2;
        private String postCode;
        private String country;
        private String phoneNumber;
        private String firstName;
        private String lastName;
        private Buyer buyer;
        private String city;

        public DeliveryDetails.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public DeliveryDetails.Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public DeliveryDetails.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public DeliveryDetails.Builder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public DeliveryDetails.Builder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public DeliveryDetails.Builder postCode (String postCode) {
            this.postCode = postCode;
            return this;
        }

        public DeliveryDetails.Builder country(String country) {
            this.country = country;
            return this;
        }

        public DeliveryDetails.Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public DeliveryDetails.Builder buyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }
        public DeliveryDetails.Builder city(String city) {
            this.city = city;
            return this;
        }


        public DeliveryDetails build() {
            return new DeliveryDetails(this);
        }
    }
}


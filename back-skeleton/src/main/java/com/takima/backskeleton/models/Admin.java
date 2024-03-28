package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "administrator")
@Getter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;
    @Column(name = "fname")
    private String firstName;
    @Column(name = "lname")
    private String lastName;
    @Column(name="mail")
    private String email;
    
    private Admin(Admin.Builder admin) {
        this.id = admin.id;
        this.firstName = admin.firstName;
        this.lastName = admin.lastName;
        this.email = admin.email;
    }

    public Admin() {
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;

        public Admin.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Admin.Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Admin.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Admin.Builder email(String email) {
            this.email = email;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}


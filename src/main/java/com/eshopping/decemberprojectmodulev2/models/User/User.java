package com.eshopping.decemberprojectmodulev2.models.User;

import com.eshopping.decemberprojectmodulev2.models.BaseModel;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class User extends BaseModel {

    private String email;
    private String username;
    private String password;
    private String phone;
    @Embedded
    private Name name;
    @Embedded
    private Address address;

    public User() {
    }

    public User(String email, String username, String phone, Name name, Address address) {
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.name = name;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

package com.eshopping.decemberprojectmodulev2.models.User;

import com.eshopping.decemberprojectmodulev2.models.BaseModel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Address {
    private String city;
    private String street;
    private Integer number;
    private String zipcode;
    @Embedded
    private Geolocation geolocation;

    public Address() {
    }

    public Address(String city, String street, Integer number, String zipcode, Geolocation geolocation) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.geolocation = geolocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }
}

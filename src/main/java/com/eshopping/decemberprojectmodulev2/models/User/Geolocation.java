package com.eshopping.decemberprojectmodulev2.models.User;

import com.eshopping.decemberprojectmodulev2.models.BaseModel;
import jakarta.persistence.Entity;

@Entity
public class Geolocation extends BaseModel {
    private String lat;
    private String longitude;

    public Geolocation() {
    }

    public Geolocation(String lat, String longitude) {
        this.lat = lat;
        this.longitude = longitude;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

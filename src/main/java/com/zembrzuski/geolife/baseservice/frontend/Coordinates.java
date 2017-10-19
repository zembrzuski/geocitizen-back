package com.zembrzuski.geolife.baseservice.frontend;

public class Coordinates {

    private Float lat;
    private Float lng;

    public Coordinates(Float lat, Float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }
}

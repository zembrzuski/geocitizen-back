package com.zembrzuski.geolife.baseservice.frontend;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Point {

    private final Float lat;
    private final Float lng;
    private final String timestamp; // TODO timestamp nao eh muito bom que seja um string.

    @JsonInclude(JsonInclude.Include.NON_NULL) // or @JsonInclude(Include.NON_EMPTY)
    private final String mode; // TODO mode nao eh muito bom que seja string. melhor seria uma enum ou algo que o valha.

    public Point(Float lat, Float lng, String timestamp, String mode) {
        this.lat = lat;
        this.lng = lng;
        this.timestamp = timestamp;
        this.mode = mode;
    }

    public Float getLat() {
        return lat;
    }

    public Float getLng() {
        return lng;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMode() {
        return mode;
    }

}

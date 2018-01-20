package com.zembrzuski.geolife.baseservice.entity.geolife;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.joda.time.DateTime;

public class Path {

    private Point point;

    //@JsonDeserialize(using = CustomDateDeserializer.class)
    private DateTime timestamp;
    private String mode;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
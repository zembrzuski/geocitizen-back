package com.zembrzuski.geolife.baseservice.entity.geolife;

import org.joda.time.DateTime;

public class Path {

    private Point point;
    // TODO muito ruim o timestamp com string. Mas, por ora, nao preciso disso.
    // o ideal eh serializar esse cara bem bonito com resttemplate e jackson.
    private String timestamp;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
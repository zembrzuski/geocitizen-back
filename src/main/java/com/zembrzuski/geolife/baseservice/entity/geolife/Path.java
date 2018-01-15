package com.zembrzuski.geolife.baseservice.entity.geolife;

public class Path {

    private Point point;
    // TODO muito ruim o timestamp com string. Mas, por ora, nao preciso disso.
    // o ideal eh serializar esse cara bem bonito com resttemplate e jackson.
    private String timestamp;
    private String mode;

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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
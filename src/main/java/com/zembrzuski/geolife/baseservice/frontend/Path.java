package com.zembrzuski.geolife.baseservice.frontend;

import java.util.List;

public class Path {

    private final String id;
    private final List<Point> points;
    private final String firstTimestamp;
    private final String lastTimestamp;

    public Path(String id, List<Point> points, String firstTimestamp, String lastTimestamp) {
        this.id = id;
        this.points = points;
        this.firstTimestamp = firstTimestamp;
        this.lastTimestamp = lastTimestamp;
    }

    public String getId() {
        return id;
    }

    public List<Point> getPoints() {
        return points;
    }

    public String getFirstTimestamp() {
        return firstTimestamp;
    }

    public String getLastTimestamp() {
        return lastTimestamp;
    }
}

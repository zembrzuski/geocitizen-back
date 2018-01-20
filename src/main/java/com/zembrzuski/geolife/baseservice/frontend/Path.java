package com.zembrzuski.geolife.baseservice.frontend;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.List;

public class Path {

    private final String id;
    private final List<Point> points;
    private final DateTime firstTimestamp;
    private final DateTime lastTimestamp;

    public Path(String id, List<Point> points, DateTime firstTimestamp, DateTime lastTimestamp) {
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

    public DateTime getFirstTimestamp() {
        return firstTimestamp;
    }

    public DateTime getLastTimestamp() {
        return lastTimestamp;
    }
}

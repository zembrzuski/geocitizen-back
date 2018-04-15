package com.zembrzuski.geolife.baseservice.frontend;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.Date;
import java.util.List;

public class Path {

    private final String id;
    private final List<Point> points;
    private final Date firstTimestamp;
    private final Date lastTimestamp;

    public Path(String id, List<Point> points, Date firstTimestamp, Date lastTimestamp) {
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

    public Date getFirstTimestamp() {
        return firstTimestamp;
    }

    public Date getLastTimestamp() {
        return lastTimestamp;
    }
}

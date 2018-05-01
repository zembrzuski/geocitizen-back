package com.zembrzuski.geolife.baseservice.frontend;

import java.util.Date;
import java.util.List;

public class Path {

    private final String id;
    private final List<Point> points;
    private final RichDate firstTimestamp;
    private final RichDate lastTimestamp;

    public Path(String id, List<Point> points, Date firstTimestamp, Date lastTimestamp) {
        this.id = id;
        this.points = points;
        this.firstTimestamp = new RichDate(firstTimestamp);
        this.lastTimestamp = new RichDate(lastTimestamp);
    }

    public String getId() {
        return id;
    }

    public List<Point> getPoints() {
        return points;
    }

    public RichDate getFirstTimestamp() {
        return firstTimestamp;
    }

    public RichDate getLastTimestamp() {
        return lastTimestamp;
    }
}

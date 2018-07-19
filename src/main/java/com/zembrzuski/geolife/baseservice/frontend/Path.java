package com.zembrzuski.geolife.baseservice.frontend;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Path {

    private String id;
    private List<Point> points;
    private RichDate firstTimestamp;
    private RichDate lastTimestamp;

    public Path(String id, List<Point> points, Date firstTimestamp, Date lastTimestamp) {
        this.id = id;
        this.points = points;
        this.firstTimestamp = new RichDate(firstTimestamp);
        this.lastTimestamp = new RichDate(lastTimestamp);
    }

}

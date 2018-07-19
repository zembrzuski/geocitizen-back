package com.zembrzuski.geolife.baseservice.frontend;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.Date;

@Data
@NoArgsConstructor
public class Point {

    private Float lat;
    private Float lng;
    private Date timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL) // or @JsonInclude(Include.NON_EMPTY)
    private String mode; // TODO mode nao eh muito bom que seja string. melhor seria uma enum ou algo que o valha.

    public Point(Float lat, Float lng, Date timestamp, String mode) {
        this.lat = lat;
        this.lng = lng;
        this.timestamp = timestamp;
        this.mode = mode;
    }



}

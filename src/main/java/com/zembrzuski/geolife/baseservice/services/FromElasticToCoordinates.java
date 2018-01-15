package com.zembrzuski.geolife.baseservice.services;

import com.zembrzuski.geolife.baseservice.entity.geolife.Track;
import com.zembrzuski.geolife.baseservice.frontend.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FromElasticToCoordinates {

    @Autowired
    private FromElasticToCoordinates fromElasticToCoordinates;

    public List<Point> fromElasticToCoordinates(Track elasticResponse) {
        return elasticResponse.get_source().getPath()
                .stream()
                .map(x -> {
                    List<Float> coordinates = x.getPoint().getCoordinates();
                    return new Point(coordinates.get(1), coordinates.get(0), x.getTimestamp(), x.getMode());
                })
                .collect(Collectors.toList());

    }

}

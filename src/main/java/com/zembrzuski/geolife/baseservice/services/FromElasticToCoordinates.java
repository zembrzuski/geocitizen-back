package com.zembrzuski.geolife.baseservice.services;

import com.zembrzuski.geolife.baseservice.entity.geolife.Track;
import com.zembrzuski.geolife.baseservice.frontend.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FromElasticToCoordinates {

    @Autowired
    private FromElasticToCoordinates fromElasticToCoordinates;

    public List<Coordinates> fromElasticToCoordinates(Track elasticResponse) {
        return elasticResponse.get_source().getPath()
                .stream()
                .map(x -> {
                    List<Float> coordinates = x.getPoint().getCoordinates();
                    float lat = coordinates.get(1);
                    float lng = coordinates.get(0);

                    return new Coordinates(lat, lng);
                })
                .collect(Collectors.toList());

    }

}

package com.zembrzuski.geolife.baseservice.services;

import com.zembrzuski.geolife.baseservice.entity.geolife.Track;
import com.zembrzuski.geolife.baseservice.frontend.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FromTrackToPath {

    @Autowired
    private FromElasticToCoordinates fromElasticToCoordinates;

    public Path execute(Track track) {
        return new Path(
                track.get_id(),
                fromElasticToCoordinates.fromElasticToCoordinates(track),
                track.get_source().getPath().get(0).getTimestamp(),
                track.get_source().getPath().get(track.get_source().getPath().size()-1).getTimestamp()
        );
    }

}

package com.zembrzuski.geolife.baseservice;

import com.zembrzuski.geolife.baseservice.entity.geolife.Track;
import com.zembrzuski.geolife.baseservice.frontend.Coordinates;
import com.zembrzuski.geolife.baseservice.frontend.Path;
import com.zembrzuski.geolife.baseservice.services.FromElasticToCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@RequestMapping(value = "/track")
public class TrackController {

    @Value("${elasticsearch_url}")
    private String elasticsearchUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FromElasticToCoordinates fromElasticToCoordinates;

    @RequestMapping(value = "/by-id/{trackId}", method = RequestMethod.GET)
    public ResponseEntity<Path> retrieveTrackById(@PathVariable String trackId) {
        Track elasticResponse = restTemplate.getForObject(elasticsearchUrl + "/" + trackId, Track.class);

        List<Coordinates> coordinatesToRespond = fromElasticToCoordinates.fromElasticToCoordinates(elasticResponse);

        return ResponseEntity
                .ok()
                .header("Cache", "no-cache")
                .header("header2", "value2")
                .body(new Path(coordinatesToRespond))
                ;
    }

}

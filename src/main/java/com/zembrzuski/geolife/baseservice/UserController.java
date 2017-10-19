package com.zembrzuski.geolife.baseservice;

import com.google.common.collect.Maps;
import com.zembrzuski.geolife.baseservice.entity.geolife.ElasticResponse;
import com.zembrzuski.geolife.baseservice.entity.geolife.Track;
import com.zembrzuski.geolife.baseservice.frontend.Coordinates;
import com.zembrzuski.geolife.baseservice.frontend.Path;
import com.zembrzuski.geolife.baseservice.frontend.Paths;
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
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@RequestMapping(value = "/user")
public class UserController {

    @Value("${elasticsearch_url}")
    private String elasticsearchUrl;

    @Value("${find_by_term}")

    private String findByTerm;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FromElasticToCoordinates fromElasticToCoordinates;

    @RequestMapping(value = "/by-user-id/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Paths> retrieveTrackByUser(@PathVariable String userId) {
        String query = String.format(findByTerm, "userId", userId);

        System.out.println("a");

        ElasticResponse elasticResponse =
                restTemplate.postForObject(elasticsearchUrl + "/_search", query, ElasticResponse.class);

        System.out.println("b");

        List<Track> tracks = elasticResponse.getAllTracks();

        List<Path> allPaths = tracks
                .stream()
                .map(track -> new Path(fromElasticToCoordinates.fromElasticToCoordinates(track)))
                .collect(Collectors.toList());

        System.out.println("c");

        Paths paths = new Paths(allPaths);

        return ResponseEntity
                .ok()
                .header("Cache", "no-cache")
                .header("header2", "value2")
                .body(paths);
    }

}

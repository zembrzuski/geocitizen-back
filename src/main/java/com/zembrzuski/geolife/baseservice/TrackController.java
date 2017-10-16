package com.zembrzuski.geolife.baseservice;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Configuration
@RequestMapping(value = "/track")
public class TrackController {

    @Value("${elasticsearch_url}")
    private String elasticsearchUrl;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/by-id/{trackId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> retrieveTrackById(@PathVariable String trackId) {
        Map elasticResponse = restTemplate.getForObject(elasticsearchUrl + "/" + trackId, Map.class);

        Map<String, Object> myResponse = Maps.newHashMap((Map) elasticResponse.get("_source"));
        myResponse.put("_id", elasticResponse.get("_id"));

        return ResponseEntity
                .ok()
                .header("Cache", "no-cache")
                .header("header2", "value2")
                .body(myResponse)
                ;
    }

}

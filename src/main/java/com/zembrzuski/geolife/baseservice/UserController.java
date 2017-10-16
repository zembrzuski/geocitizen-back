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

import java.util.List;
import java.util.Map;

@Configuration
@RequestMapping(value = "/user")
public class UserController {

    @Value("${elasticsearch_url}")
    private String elasticsearchUrl;

    @Value("${find_by_term}")

    private String findByTerm;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/by-user-id/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> retrieveTrackByUser(@PathVariable String userId) {
        String query = String.format(findByTerm, "userId", userId);
        Map elasticResponse = restTemplate.postForObject(elasticsearchUrl + "/_search", query, Map.class);

        List tracks = (List) ((Map) elasticResponse.get("hits")).get("hits");

        Map<String, Object> myResponse = Maps.newHashMap();
        myResponse.put("tracks", tracks);

        return ResponseEntity
                .ok()
                .header("Cache", "no-cache")
                .header("header2", "value2")
                .body(myResponse)
                ;
    }

}

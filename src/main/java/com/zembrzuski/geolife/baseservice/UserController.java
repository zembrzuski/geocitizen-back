package com.zembrzuski.geolife.baseservice;

import com.zembrzuski.geolife.baseservice.entity.geolife.ElasticResponse;
import com.zembrzuski.geolife.baseservice.frontend.Path;
import com.zembrzuski.geolife.baseservice.frontend.Paths;
import com.zembrzuski.geolife.baseservice.services.FromTrackToPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
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
    private FromTrackToPath fromTrackToPath;

    @RequestMapping(value = "/by-user-id/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Paths> retrieveTrackByUser(@PathVariable String userId) {
        String query = String.format(findByTerm, "userId", userId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(query, headers);

        List<Path> allPaths = restTemplate
                .postForObject(elasticsearchUrl + "/_search", entity, ElasticResponse.class)
                .getAllTracks()
                .stream()
                .map(track -> fromTrackToPath.execute(track))
                .collect(Collectors.toList());

        return ResponseEntity
                .ok()
                .header("Cache", "no-cache")
                .header("header2", "value2")
                .body(new Paths(allPaths));
    }

}

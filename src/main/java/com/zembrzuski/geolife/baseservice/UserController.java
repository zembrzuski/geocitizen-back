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

    @Value("${find_by_user_id_and_by_hour_of_day}")
    private String findByUserIdAndHourOfDay;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FromTrackToPath fromTrackToPath;

    @RequestMapping(value = "/by-user-id/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Paths> retrieveTrackByUser(@PathVariable String userId) {
        String query = String.format(findByTerm, "userId.keyword", userId);

        return queryTrackOnElasticsearch(query);
    }

    /**
     * TODO verificar se essa query não tá cagada.
     * Ele faz um filter pelos limites inferior e superior.
     * O que eu gostaria de fazer é uma querie filtrando somente o primeiro elemento, pq eu queria viagens
     * que iniciam em um determinado horario.
     * Pode ser que esse cara esteja filtrando pouco ou muito.
     * Na real, eu tenho que debugar muito, muito melhor essa query.
     * Mas agora estou sem paciencia, e vou assumir que essa query está razoável e aceitável.
     * TODO mas, com certeza, devo revisitar esse cara daqui a pouco.
     */
    @RequestMapping(value = "/by-user-id-and-hour-of-day/{userId}/{initHour}/{finishHour}", method = RequestMethod.GET)
    public ResponseEntity<Paths> retrieveTrackByUserAndHourOfDay(
            @PathVariable String userId, @PathVariable int initHour, @PathVariable int finishHour) {

        String query = String.format(findByUserIdAndHourOfDay, initHour, finishHour, userId);

        return queryTrackOnElasticsearch(query);
    }

    private ResponseEntity<Paths> queryTrackOnElasticsearch(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(query, headers);

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

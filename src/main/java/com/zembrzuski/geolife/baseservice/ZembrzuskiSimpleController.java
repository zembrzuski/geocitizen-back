package com.zembrzuski.geolife.baseservice;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Configuration
@RequestMapping(value = "/track")
public class ZembrzuskiSimpleController {

    @Value("${elasticsearch_url}")
    private String elasticsearchUrl;

    @Value("${find_by_term}")
    private String findByTerm;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * TODO continuar implementando essa classe.
     * Esse endpoint ainda não está filtrando pelo trackId
     *
     * Depois, tenho que criar o endpoint que dá todas as rotas de um determinado usuário.
     *
     * Depois, tenho que fazer alguma parada com visualização de informações. Para, de fato,
     * ver se as rotas se repetem.
     *
     * Por fim, acho justo de implementar as coisas nos artigos que lerei.
     *
     * Agora, vou ler um artigo.
     */

    @RequestMapping(value = "/by-id/{trackId}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> retrieveTrackById(@PathVariable String trackId) {
        Map<String, String> myCrazyEntity = Maps.newHashMap();
        myCrazyEntity.put("a", "alfa");
        myCrazyEntity.put("b", "beta");

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

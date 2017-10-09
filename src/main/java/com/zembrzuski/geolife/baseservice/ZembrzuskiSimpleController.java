package com.zembrzuski.geolife.baseservice;

import com.google.common.collect.Maps;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class ZembrzuskiSimpleController {

    @RequestMapping(value = "/zembrzuski/{myParam}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, String>> persistPerson(@PathVariable String myParam) {

        Map<String, String> myCrazyEntity = Maps.newHashMap();
        myCrazyEntity.put("a", "alfa");
        myCrazyEntity.put("b", "beta");

        return ResponseEntity
                .ok()
                .header("Cache", "no-cache")
                .header("header2", "value2")
                .body(myCrazyEntity)
            ;
    }

}

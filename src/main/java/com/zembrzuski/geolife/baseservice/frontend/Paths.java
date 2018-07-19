package com.zembrzuski.geolife.baseservice.frontend;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Paths {

    private List<Path> paths;

    public Paths(List<Path> paths) {
        this.paths = paths;
    }

}

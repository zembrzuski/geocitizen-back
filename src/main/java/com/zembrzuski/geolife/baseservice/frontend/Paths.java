package com.zembrzuski.geolife.baseservice.frontend;

import java.util.List;

public class Paths {

    private List<Path> paths;

    public Paths(List<Path> paths) {
        this.paths = paths;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }
}

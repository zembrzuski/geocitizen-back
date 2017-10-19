package com.zembrzuski.geolife.baseservice.entity.geolife;

import java.util.List;

public class Source {

    private String userId;
    private List<Path> path;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Path> getPath() {
        return path;
    }

    public void setPath(List<Path> path) {
        this.path = path;
    }
}

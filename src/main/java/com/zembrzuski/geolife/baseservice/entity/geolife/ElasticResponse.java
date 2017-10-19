package com.zembrzuski.geolife.baseservice.entity.geolife;

import java.util.List;

public class ElasticResponse {

    private Hits hits;

    public Hits getHits() {
        return hits;
    }

    public List<Track> getAllTracks() {
        return hits.getHits();
    }

    public void setHits(Hits hits) {
        this.hits = hits;
    }
}


class Hits {
    private List<Track> hits;

    public List<Track> getHits() {
        return hits;
    }

    public void setHits(List<Track> hits) {
        this.hits = hits;
    }
}


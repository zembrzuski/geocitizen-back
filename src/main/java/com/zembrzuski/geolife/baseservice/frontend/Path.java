package com.zembrzuski.geolife.baseservice.frontend;

import java.util.List;

public class Path {

    private List<Coordinates> coordinates;

    public Path(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
    }
}

package com.zembrzuski.geolife.baseservice.services;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceCalculatorTest {

    @Test
    public void poaToSaopaulo() {
        double lat1 = 30.0346;
        double long1 = 51.2177;
        double lat2 = 23.5505;
        double long2 = 46.6333;
        double k = new DistanceCalculator().distance(lat1, long1, lat2, long2, 'K');

        System.out.println(k);
    }

    @Test
    public void outro() {
        double lat1 = 30.0346;
        double long1 = 51.2177;
        double lat2 = 23.5505;
        double long2 = -46.6333;
        double k = new DistanceCalculator().distance(lat1, long1, lat2, long2, 'K');

        System.out.println(k);
    }

}
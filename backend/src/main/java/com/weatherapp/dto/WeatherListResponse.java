package com.weatherapp.dto;

import java.util.List;

public class WeatherListResponse {

    private final int count;
    private final List<CityWeather> cities;

    public WeatherListResponse(int count, List<CityWeather> cities) {
        this.count = count;
        this.cities = cities;
    }

    public int getCount() {
        return count;
    }

    public List<CityWeather> getCities() {
        return cities;
    }
}

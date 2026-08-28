package com.weatherapp.dto;

public class CityWeather {

    private final long id;
    private final String name;
    private final String country;
    private final String description;
    private final Double temperature;
    private final Integer humidity;
    private final Double windSpeed;
    private final Integer clouds;

    public CityWeather(
            long id,
            String name,
            String country,
            String description,
            Double temperature,
            Integer humidity,
            Double windSpeed,
            Integer clouds
    ) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.description = description;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Integer getClouds() {
        return clouds;
    }
}

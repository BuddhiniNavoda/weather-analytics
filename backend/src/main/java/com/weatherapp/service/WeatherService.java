package com.weatherapp.service;

import com.weatherapp.dto.CityWeather;
import com.weatherapp.dto.OpenWeatherResponse;
import com.weatherapp.dto.WeatherListResponse;
import com.weatherapp.repository.CityFileReader;
import com.weatherapp.repository.OpenWeatherMapClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    private final CityFileReader cityFileReader;
    private final OpenWeatherMapClient openWeatherMapClient;

    public WeatherService(CityFileReader cityFileReader, OpenWeatherMapClient openWeatherMapClient) {
        this.cityFileReader = cityFileReader;
        this.openWeatherMapClient = openWeatherMapClient;
    }

    public WeatherListResponse getWeatherForCities() {
        List<String> cityIds = cityFileReader.readCityIds();
        List<CityWeather> cities = new ArrayList<>();

        for (String cityId : cityIds) {
            OpenWeatherResponse data = openWeatherMapClient.fetchWeather(cityId);
            cities.add(toCityWeather(data));
        }

        return new WeatherListResponse(cities.size(), cities);
    }

    private CityWeather toCityWeather(OpenWeatherResponse data) {
        String description = null;
        if (data.getWeather() != null && !data.getWeather().isEmpty()) {
            description = data.getWeather().get(0).getDescription();
        }

        Double temperature = data.getMain() != null ? data.getMain().getTemp() : null;
        Integer humidity = data.getMain() != null ? data.getMain().getHumidity() : null;
        Double windSpeed = data.getWind() != null ? data.getWind().getSpeed() : null;
        Integer clouds = data.getClouds() != null ? data.getClouds().getAll() : null;
        String country = data.getSys() != null ? data.getSys().getCountry() : null;

        return new CityWeather(
                data.getId(),
                data.getName(),
                country,
                description,
                temperature,
                humidity,
                windSpeed,
                clouds
        );
    }
}

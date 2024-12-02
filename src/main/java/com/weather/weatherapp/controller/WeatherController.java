package com.weather.weatherapp.controller;

import com.weather.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Endpoint to get weather forecast by city name
    @GetMapping("/weather/{city}")
    public String getWeather(@PathVariable String city) throws IOException {
        // Fetch weather data from OpenWeatherMap API
        String jsonResponse = weatherService.getWeatherData(city);

        // Parse and return the weather data
        return weatherService.parseWeatherData(jsonResponse);
    }
}


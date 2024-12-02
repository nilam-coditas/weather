package com.weather.weatherapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Method to get weather data from OpenWeatherMap API
    public String getWeatherData(String city) {
        String url = String.format(API_URL, city, apiKey);
        return restTemplate.getForObject(url, String.class);
    }

    // Method to parse and return weather information
    public String parseWeatherData(String jsonResponse) {
        return jsonResponse;
    }
}

package com.example.weather.controller;

import com.example.weather.entities.WeatherApiObject;
import com.example.weather.services.WeatherApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/weatherapi")
@RequiredArgsConstructor
public class WeatherApiController {

    private final WeatherApiService weatherApiService;

    @Value("${api.weatherapi.host}")
    private String host;

    @Value(("${api.weatherapi.key}"))
    private String key;

    @GetMapping("/{cityName}")
    public WeatherApiObject getCityWeather(@PathVariable(value = "cityName") String cityName) throws IOException {
        return weatherApiService.getCurrentWeather(getUrl(cityName));
    }

    @PostMapping
    public WeatherApiObject create(@RequestBody String json) throws JsonProcessingException {
        return weatherApiService.create(json);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") WeatherApiObject weatherApiObject) {
        weatherApiService.delete(weatherApiObject);
    }

    public String getUrl(String cityName) {
        return host + "/v1/current.json?key=" + key + "&q=" + cityName;
    }

}

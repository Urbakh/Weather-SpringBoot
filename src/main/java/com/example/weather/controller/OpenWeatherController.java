package com.example.weather.controller;

import com.example.weather.entities.OpenWeatherObject;
import com.example.weather.services.OpenWeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/openweather")
@RequiredArgsConstructor
public class OpenWeatherController {

    @Value("${api.openweather.host}")
    private String host;

    @Value("${api.openweather.appid}")
    private String appId;

    private final OpenWeatherService openWeatherService;

    @GetMapping("/{cityName}")
    public OpenWeatherObject getCityWeather(@PathVariable(name = "cityName") String cityName) throws IOException {

        return openWeatherService.getCurrentWeather(getUrl(cityName));
    }

    @PostMapping
    public OpenWeatherObject create(@RequestBody String json) throws JsonProcessingException {
        return openWeatherService.create(json);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") OpenWeatherObject openWeatherObject) {
        openWeatherService.delete(openWeatherObject);
    }

    public String getUrl(String cityName) {
        return host + "/data/2.5/weather?q=" + cityName + "&units=metric&appid=" + appId;
    }
}

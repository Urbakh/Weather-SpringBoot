package com.example.weather.controller;

import com.example.weather.entities.GeneralWeather;
import com.example.weather.services.GeneralWeatherService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generalweather")
@RequiredArgsConstructor
@Data
public class GeneralWeatherController {

    @Value("${api.openweather.host}")
    private String hostOpenWeather;

    @Value("${api.openweather.appid}")
    private String appId;

    @Value("${api.weatherapi.host}")
    private String hostWeatherApi;

    @Value(("${api.weatherapi.key}"))
    private String key;

    private final GeneralWeatherService generalWeatherService;

    @GetMapping("/{cityName}")
    public Iterable<GeneralWeather> getCurrentWeather(@PathVariable("cityName") String cityName) {
        return generalWeatherService.getCityWeather(cityName);
    }

    @PostMapping("/{id}")
    public GeneralWeather create(@PathVariable("id") Long id) {
        return generalWeatherService.create(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") GeneralWeather generalWeather) {
        generalWeatherService.delete(generalWeather);
    }

    public String getUrlOpenweather(String cityName) {
        return hostOpenWeather + "/data/2.5/weather?q=" + cityName + "&units=metric&appid=" + appId;
    }

    public String getUrlWeatherApi(String cityName) {
        return hostWeatherApi + "/v1/current.json?key=" + key + "&q=" + cityName;
    }
}

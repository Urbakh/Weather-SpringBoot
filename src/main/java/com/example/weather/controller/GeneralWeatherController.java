package com.example.weather.controller;

import com.example.weather.entities.GeneralWeather;
import com.example.weather.services.GeneralWeatherService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generalweather")
@RequiredArgsConstructor
@Data
public class GeneralWeatherController {

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

}

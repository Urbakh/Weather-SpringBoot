package com.example.weather.dao;

import com.example.weather.entities.GeneralWeather;
import org.springframework.data.repository.CrudRepository;

public interface GeneralWeatherDao extends CrudRepository<GeneralWeather, Long> {
    Iterable<GeneralWeather> findAllByName(String name);
}

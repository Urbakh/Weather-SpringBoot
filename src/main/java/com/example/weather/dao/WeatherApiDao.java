package com.example.weather.dao;

import com.example.weather.entities.WeatherApiObject;
import org.springframework.data.repository.CrudRepository;

public interface WeatherApiDao extends CrudRepository<WeatherApiObject, Long> {
    Iterable<WeatherApiObject> findAllById(Long id);
}

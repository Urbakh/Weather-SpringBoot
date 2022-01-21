package com.example.weather.dao;

import com.example.weather.entities.OpenWeatherObject;
import org.springframework.data.repository.CrudRepository;

public interface OpenWeatherDao extends CrudRepository<OpenWeatherObject, Long> {
    Iterable<OpenWeatherObject> findAllByOpenWeatherObjectId(Long id);
    OpenWeatherObject findByOpenWeatherObjectId(Long id);
}

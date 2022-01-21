package com.example.weather.services;

import com.example.weather.dao.WeatherApiDao;
import com.example.weather.entities.WeatherApiObject;
import com.example.weather.mappers.WeatherApiMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class WeatherApiService extends WeatherApiMapper {

    private final WeatherApiDao weatherApiDao;

    public WeatherApiObject getCurrentWeather(String jsonUrl) throws IOException {
        return WeatherApiMapper.mapUrlToObject(new URL(jsonUrl));
    }

    public WeatherApiObject create(String json) throws JsonProcessingException {
        return weatherApiDao.save(WeatherApiMapper.mapJsonToObject(json));
    }

    @Transactional
    public void delete(WeatherApiObject weatherApiObject) {
        weatherApiDao.delete(weatherApiObject);
    }
}

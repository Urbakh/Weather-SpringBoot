package com.example.weather.services;

import com.example.weather.dao.OpenWeatherDao;
import com.example.weather.entities.OpenWeatherObject;
import com.example.weather.mappers.OpenWeatherMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class OpenWeatherService {

    private final OpenWeatherDao openWeatherDao;

    public OpenWeatherObject getCurrentWeather(String jsonUrl) throws IOException  {
        return OpenWeatherMapper.mapUrlToObject(new URL(jsonUrl));
    }

    public OpenWeatherObject create(String json) throws JsonProcessingException {
        return openWeatherDao.save(OpenWeatherMapper.mapJsonToObject(json));
    }

    @Transactional
    public void delete(OpenWeatherObject openWeatherObject) {
        openWeatherDao.delete(openWeatherObject);
    }
}

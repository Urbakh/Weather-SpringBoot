package com.example.weather.mappers;

import com.example.weather.entities.WeatherApiObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class WeatherApiMapper {

    public static WeatherApiObject mapUrlToObject(URL jsonUrl) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonUrl, WeatherApiObject.class);
    }

    public static WeatherApiObject mapJsonToObject(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(json, WeatherApiObject.class);
    }

}

package com.example.weather.mappers;

import com.example.weather.entities.OpenWeatherObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class OpenWeatherMapper {

    public static OpenWeatherObject mapUrlToObject(URL jsonUrl) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonUrl, OpenWeatherObject.class);
    }

    public static OpenWeatherObject mapJsonToObject(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(json, OpenWeatherObject.class);
    }
}

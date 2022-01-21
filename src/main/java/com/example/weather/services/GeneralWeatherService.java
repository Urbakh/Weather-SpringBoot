package com.example.weather.services;

import com.example.weather.dao.GeneralWeatherDao;
import com.example.weather.dao.OpenWeatherDao;
import com.example.weather.dao.WeatherApiDao;
import com.example.weather.entities.GeneralWeather;
import com.example.weather.entities.OpenWeatherObject;
import com.example.weather.entities.WeatherApiObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GeneralWeatherService {

    private final OpenWeatherDao openWeatherDao;

    private final WeatherApiDao weatherApiDao;

    private final GeneralWeatherDao generalWeatherDao;

    public Iterable<GeneralWeather> getCityWeather(String name) {
        return generalWeatherDao.findAllByName(name);
    }

    public GeneralWeather create(Long id) {
        OpenWeatherObject openWeatherObject;
        WeatherApiObject weatherApiObject;

        openWeatherObject = openWeatherDao.findByOpenWeatherObjectId(id);
        weatherApiObject = weatherApiDao.findById(id).orElse(null);

        if (openWeatherObject != null && weatherApiObject != null) {
            GeneralWeather generalWeather = mergeWeather(openWeatherObject, weatherApiObject);

            return generalWeatherDao.save(generalWeather);
        }

        throw new NullPointerException("OpenWeatherObject or WeatherApiObject are null");
    }

    @Transactional
    public void delete(GeneralWeather generalWeather) {
        for (OpenWeatherObject openWeatherObject : openWeatherDao.findAllByOpenWeatherObjectId(generalWeather.getId())) {
            for (WeatherApiObject weatherApiObject : weatherApiDao.findAllById(generalWeather.getId())) {
                weatherApiDao.delete(weatherApiObject);
            }
            openWeatherDao.delete(openWeatherObject);
        }

        generalWeatherDao.delete(generalWeather);
    }

    public GeneralWeather mergeWeather(OpenWeatherObject openWeatherObject, WeatherApiObject weatherApiObject) {
        return GeneralWeather.builder()
                .feelslike((openWeatherObject.getMain().getFeelslike() + weatherApiObject.getCurrent().getFeelslikeC()) / 2)
                .description(weatherApiObject.getCurrent().getCondition().getText())
                .gustKph(weatherApiObject.getCurrent().getGustKph())
                .hudminity((openWeatherObject.getMain().getHumidity() + weatherApiObject.getCurrent().getHumidity()) / 2)
                .name(openWeatherObject.getName())
                .temp((openWeatherObject.getMain().getTemp() + weatherApiObject.getCurrent().getTempC()) / 2)
                .windKph((openWeatherObject.getWind().getSpeed() + weatherApiObject.getCurrent().getWindKph()) / 2)
                .localtimes(weatherApiObject.getLocation().getLocaltimes())
                .pressure((openWeatherObject.getMain().getPressure() + weatherApiObject.getCurrent().getPressureMb()) /2)
                .visibility(openWeatherObject.getVisibility())
                .openWeatherObject(openWeatherObject)
                .weatherApiObject(weatherApiObject).build();
    }
}


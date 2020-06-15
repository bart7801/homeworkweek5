package com.bart.homeworkweek5.service;

import com.bart.homeworkweek5.model.City;
import com.bart.homeworkweek5.weather.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherService {

    @Value("${key}")
    private String key;
    @Value("${lang}")
    private String lang;
    @Value("${units}")
    private String units;

    private String url;
    private final City city = new City();

    public City getCity() {
        return city;
    }

    RestTemplate restTemplate = new RestTemplate();

    public void getDateCity(String cityName) {

        url = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=" + units + "&lang=" + lang + "&APPID=" + key;

        try {
            Weather weatherInfo = restTemplate.getForObject(url, Weather.class);
            city.setCityName(weatherInfo.getName());
            city.setLon(weatherInfo.getCoord().getLon());
            city.setLat(weatherInfo.getCoord().getLat());
            city.setId1(weatherInfo.getWeather().get(0).getId());
            city.setMain(weatherInfo.getWeather().get(0).getMain());
            city.setDescription(weatherInfo.getWeather().get(0).getDescription());
            city.setIcon(weatherInfo.getWeather().get(0).getIcon());
            city.setBase(weatherInfo.getBase());
            city.setTemp(weatherInfo.getMain().getTemp());
            city.setFeelsLike(weatherInfo.getMain().getFeelsLike());
            city.setTempMin(weatherInfo.getMain().getTempMin());
            city.setTempMax(weatherInfo.getMain().getTempMax());
            city.setPressure(weatherInfo.getMain().getPressure());
            city.setHumidity(weatherInfo.getMain().getHumidity());
            city.setVisibility(weatherInfo.getVisibility());
            city.setSpeed(weatherInfo.getWind().getSpeed());
            city.setDeg(weatherInfo.getWind().getDeg());
            city.setAll(weatherInfo.getClouds().getAll());
            city.setDt(weatherInfo.getDt());
            city.setType(weatherInfo.getSys().getType());
            city.setId2(weatherInfo.getSys().getId());
            city.setCountry(weatherInfo.getSys().getCountry());
            city.setSunrise(weatherInfo.getSys().getSunrise());
            city.setSunset(weatherInfo.getSys().getSunset());
            city.setTimezone(weatherInfo.getTimezone());
            city.setId3(weatherInfo.getId());
            city.setName(weatherInfo.getName());
            city.setCod(weatherInfo.getCod());
            city.setError("ok");

        } catch (HttpClientErrorException e) {

            city.setError("error");
            city.setCityName("");
        }
    }
}

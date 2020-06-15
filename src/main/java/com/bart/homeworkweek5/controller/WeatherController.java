package com.bart.homeworkweek5.controller;

import com.bart.homeworkweek5.model.City;
import com.bart.homeworkweek5.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public String start(ModelMap model) {
        model.addAttribute("search", new City());

        return "index";
    }

    @GetMapping("/citySearch")
    public String getCity(@RequestParam("cityName") String nameCity, ModelMap model) {
        weatherService.getDateCity(nameCity);
        model.addAttribute("city", weatherService.getCity());

        return "search";
    }
}

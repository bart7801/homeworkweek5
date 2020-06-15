package com.bart.homeworkweek5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    private String cityName;
    private Double lon;
    private Double lat;
    private int id1;
    private String main;
    private String description;
    private String icon;
    private String base;
    private Double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;
    private int visibility;
    private double speed;
    private int deg;
    private int all;
    private int dt;
    private int type;
    private int id2;
    private String country;
    private int sunrise;
    private int sunset;
    private int timezone;
    private int id3;
    private String name;
    private int cod;
    private String error;

}

package pl.bswies.WeatherApp.business.models;

import lombok.Value;

import java.util.List;

@Value
public class CurrentWeatherData {
    List<WeatherInfo> weather;
    MainConditions main;
    Integer visibility;
    WindConditions wind;
    SunData sys;
    String name;
}

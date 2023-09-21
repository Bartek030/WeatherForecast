package pl.bswies.WeatherApp.business.models;

import lombok.Value;

@Value
public class WeatherInfo {
    String id;
    String main;
    String description;
    String icon;
}

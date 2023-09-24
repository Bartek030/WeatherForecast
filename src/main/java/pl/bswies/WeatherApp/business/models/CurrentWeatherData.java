package pl.bswies.WeatherApp.business.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeatherData {
    List<WeatherInfo> weather;
    MainConditions main;
    Integer visibility;
    WindConditions wind;
    SunData sys;
    String name;
}

package pl.bswies.WeatherApp.business.models;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    List<WeatherInfo> weather;
    MainConditions main;
    Integer visibility;
    WindConditions wind;
    SunData sys;
    String name;
    Integer dt;
}

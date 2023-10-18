package pl.bswies.WeatherApp.business.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecastData {
    List<WeatherData> list;
}

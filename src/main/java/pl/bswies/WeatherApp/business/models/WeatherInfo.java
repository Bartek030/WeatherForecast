package pl.bswies.WeatherApp.business.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfo {
    String id;
    String main;
    String description;
    String icon;
}

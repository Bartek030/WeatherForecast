package pl.bswies.WeatherApp.business.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SunData {
    Integer sunrise;
    Integer sunset;
}

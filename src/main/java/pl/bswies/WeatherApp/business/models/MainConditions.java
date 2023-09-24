package pl.bswies.WeatherApp.business.models;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainConditions {
    BigDecimal temp;
    BigDecimal feels_like;
    BigDecimal temp_min;
    BigDecimal temp_max;
    Integer pressure;
    Integer humidity;
}

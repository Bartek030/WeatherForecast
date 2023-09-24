package pl.bswies.WeatherApp.business.models;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WindConditions {
    BigDecimal speed;
    Integer deg;
}

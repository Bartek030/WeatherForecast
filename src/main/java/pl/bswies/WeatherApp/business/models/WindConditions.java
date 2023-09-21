package pl.bswies.WeatherApp.business.models;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class WindConditions {
    BigDecimal speed;
    Integer deg;
}

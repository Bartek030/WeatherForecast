package pl.bswies.WeatherApp.util;

import lombok.experimental.UtilityClass;
import pl.bswies.WeatherApp.business.models.WindConditions;

import java.math.BigDecimal;

@UtilityClass
public class WindConditionsExample {

    public WindConditions someWindConditions1() {
        return WindConditions.builder()
                .speed(BigDecimal.valueOf(2.57))
                .deg(240)
                .build();
    }

    public WindConditions someWindConditions2() {
        return WindConditions.builder()
                .speed(BigDecimal.valueOf(3.6))
                .deg(300)
                .build();
    }

    public WindConditions someWindConditions3() {
        return WindConditions.builder()
                .speed(BigDecimal.valueOf(1.39))
                .deg(159)
                .build();
    }
}

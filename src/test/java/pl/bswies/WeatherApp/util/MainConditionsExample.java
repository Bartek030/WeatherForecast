package pl.bswies.WeatherApp.util;

import lombok.experimental.UtilityClass;
import pl.bswies.WeatherApp.business.models.MainConditions;

import java.math.BigDecimal;

@UtilityClass
public class MainConditionsExample {

    public MainConditions someMainConditions1() {
        return MainConditions.builder()
                .temp(BigDecimal.valueOf(17.63))
                .feels_like(BigDecimal.valueOf(17.09))
                .temp_min(BigDecimal.valueOf(15))
                .temp_max(BigDecimal.valueOf(19.56))
                .pressure(1022)
                .humidity(63)
                .build();
    }

    public MainConditions someMainConditions2() {
        return MainConditions.builder()
                .temp(BigDecimal.valueOf(16.98))
                .feels_like(BigDecimal.valueOf(17.24))
                .temp_min(BigDecimal.valueOf(16.42))
                .temp_max(BigDecimal.valueOf(18.64))
                .pressure(1009)
                .humidity(96)
                .build();
    }

    public MainConditions someMainConditions3() {
        return MainConditions.builder()
                .temp(BigDecimal.valueOf(38.83))
                .feels_like(BigDecimal.valueOf(38.58))
                .temp_min(BigDecimal.valueOf(38.83))
                .temp_max(BigDecimal.valueOf(38.83))
                .pressure(1006)
                .humidity(23)
                .build();
    }
}

package pl.bswies.WeatherApp.util;

import lombok.experimental.UtilityClass;
import pl.bswies.WeatherApp.business.models.WeatherInfo;

@UtilityClass
public class WeatherInfoExample {

    public WeatherInfo someWeatherInfo1() {
        return WeatherInfo.builder()
                .id("800")
                .main("Clear")
                .description("bezchmurnie")
                .icon("01n")
                .build();
    }

    public WeatherInfo someWeatherInfo2() {
        return WeatherInfo.builder()
                .id("502")
                .main("Rain")
                .description("intensywne opady deszczu")
                .icon("10n")
                .build();
    }

    public WeatherInfo someWeatherInfo3() {
        return WeatherInfo.builder()
                .id("804")
                .main("Clouds")
                .description("zachmurzenie duże")
                .icon("04d")
                .build();
    }
}

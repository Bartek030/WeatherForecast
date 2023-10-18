package pl.bswies.WeatherApp.util;

import lombok.experimental.UtilityClass;
import pl.bswies.WeatherApp.business.models.WeatherForecastData;

import java.util.List;

@UtilityClass
public class WeatherForecastDataExample {

    public WeatherForecastData someWeatherForecastData1() {
        return WeatherForecastData.builder()
                .list(List.of(
                        WeatherDataExample.someWeatherData1(),
                        WeatherDataExample.someWeatherData2(),
                        WeatherDataExample.someWeatherData3()
                )).build();
    }
}

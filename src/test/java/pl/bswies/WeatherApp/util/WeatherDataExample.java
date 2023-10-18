package pl.bswies.WeatherApp.util;

import lombok.experimental.UtilityClass;
import pl.bswies.WeatherApp.business.models.WeatherData;

import java.util.List;

@UtilityClass
public class WeatherDataExample {

    public WeatherData someWeatherData1() {
        return WeatherData.builder()
                .weather(List.of(
                        WeatherInfoExample.someWeatherInfo1(),
                        WeatherInfoExample.someWeatherInfo2(),
                        WeatherInfoExample.someWeatherInfo3()
                ))
                .main(MainConditionsExample.someMainConditions1())
                .visibility(10000)
                .wind(WindConditionsExample.someWindConditions1())
                .sys(SunDataExample.someSunData1())
                .name("Stuttgart")
                .dt(1696876829)
                .build();
    }

    public WeatherData someWeatherData2() {
        return WeatherData.builder()
                .weather(List.of(
                        WeatherInfoExample.someWeatherInfo2(),
                        WeatherInfoExample.someWeatherInfo3(),
                        WeatherInfoExample.someWeatherInfo1()
                ))
                .main(MainConditionsExample.someMainConditions2())
                .visibility(10000)
                .wind(WindConditionsExample.someWindConditions2())
                .sys(SunDataExample.someSunData2())
                .name("Tokio")
                .dt(1696876840)
                .build();
    }

    public WeatherData someWeatherData3() {
        return WeatherData.builder()
                .weather(List.of(
                        WeatherInfoExample.someWeatherInfo3(),
                        WeatherInfoExample.someWeatherInfo1(),
                        WeatherInfoExample.someWeatherInfo2()
                ))
                .main(MainConditionsExample.someMainConditions3())
                .visibility(10000)
                .wind(WindConditionsExample.someWindConditions3())
                .sys(SunDataExample.someSunData3())
                .name("Brazylia")
                .dt(1696877030)
                .build();
    }
}

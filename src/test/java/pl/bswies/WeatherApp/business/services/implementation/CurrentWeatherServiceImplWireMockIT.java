package pl.bswies.WeatherApp.business.services.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.bswies.WeatherApp.business.models.WeatherData;
import pl.bswies.WeatherApp.configuration.RestAssuredIntegrationTestBase;
import pl.bswies.WeatherApp.configuration.wiremockSupport.CurrentWeatherControllerTestSupport;
import pl.bswies.WeatherApp.configuration.wiremockSupport.WireMockTestSupport;

import java.math.BigDecimal;

class CurrentWeatherServiceImplWireMockIT extends RestAssuredIntegrationTestBase
        implements WireMockTestSupport, CurrentWeatherControllerTestSupport {

    @Test
    void shouldReturnWeatherDataCorrectly() {
        // given
        String cityName = "Stuttgart";
        BigDecimal temperature = BigDecimal.valueOf(14.64);
        Integer pressure = 993;
        BigDecimal windSpeed = BigDecimal.valueOf(1.03);

        stubForCurrentWeather(wireMockServer, cityName);

        // when
        final WeatherData weatherData = getWeatherData(cityName);

        // then
        Assertions.assertEquals(cityName, weatherData.getName());
        Assertions.assertEquals(temperature, weatherData.getMain().getTemp());
        Assertions.assertEquals(pressure, weatherData.getMain().getPressure());
        Assertions.assertEquals(windSpeed, weatherData.getWind().getSpeed());
    }
}
package pl.bswies.WeatherApp.business.services.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.bswies.WeatherApp.business.models.WeatherForecastData;
import pl.bswies.WeatherApp.configuration.RestAssuredIntegrationTestBase;
import pl.bswies.WeatherApp.configuration.wiremockSupport.WeatherForecastControllerTestSupport;
import pl.bswies.WeatherApp.configuration.wiremockSupport.WireMockTestSupport;

import java.math.BigDecimal;

class WeatherForecastServiceImplWireMockIT extends RestAssuredIntegrationTestBase
        implements WireMockTestSupport, WeatherForecastControllerTestSupport {

    @Test
    void shouldReturnWeatherDataCorrectly() {
        // given
        String cityName = "Warszawa";
        BigDecimal temperature1 = BigDecimal.valueOf(7.1);
        BigDecimal temperature2 = BigDecimal.valueOf(7.22);
        Integer pressure1 = 998;
        Integer pressure2 = 998;
        BigDecimal windSpeed1 = BigDecimal.valueOf(4.26);
        BigDecimal windSpeed2 = BigDecimal.valueOf(4.63);

        stubForWeatherForecast(wireMockServer, cityName);

        // when
        final WeatherForecastData weatherForecastData = getForecastData(cityName);

        // then
        Assertions.assertEquals(temperature1, weatherForecastData.getList().get(0).getMain().getTemp());
        Assertions.assertEquals(temperature2, weatherForecastData.getList().get(2).getMain().getTemp());
        Assertions.assertEquals(pressure1, weatherForecastData.getList().get(0).getMain().getPressure());
        Assertions.assertEquals(pressure2, weatherForecastData.getList().get(2).getMain().getPressure());
        Assertions.assertEquals(windSpeed1, weatherForecastData.getList().get(0).getWind().getSpeed());
        Assertions.assertEquals(windSpeed2, weatherForecastData.getList().get(2).getWind().getSpeed());
    }
}
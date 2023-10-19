package pl.bswies.WeatherApp.configuration.wiremockSupport;

import io.restassured.specification.RequestSpecification;
import org.springframework.http.HttpStatus;
import pl.bswies.WeatherApp.api.CurrentWeatherController;
import pl.bswies.WeatherApp.business.models.WeatherData;

public interface CurrentWeatherControllerTestSupport {

    RequestSpecification requestSpecification();

    default WeatherData getWeatherData(final String cityName) {
        return requestSpecification()
                .pathParam("cityName", cityName)
                .get(CurrentWeatherController.CURRENT_WEATHER_URL)
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .extract()
                .as(WeatherData.class);
    }
}

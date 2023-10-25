package pl.bswies.WeatherApp.configuration.wiremockSupport;

import io.restassured.specification.RequestSpecification;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.bswies.WeatherApp.api.CurrentWeatherController;
import pl.bswies.WeatherApp.api.dto.ExceptionMessage;
import pl.bswies.WeatherApp.business.models.WeatherData;

public interface CurrentWeatherControllerTestSupport {

    RequestSpecification requestSpecification();

    default WeatherData getWeatherData(final String cityName) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("units", "metric");
        parameters.add("lang", "pl");

        return requestSpecification()
                .pathParam("cityName", cityName)
                .params(parameters)
                .get(CurrentWeatherController.CURRENT_WEATHER_URL)
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .extract()
                .as(WeatherData.class);
    }

    default ExceptionMessage throwExceptionWhileTryingToGetWeatherData(final String cityName) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("units", "metric");
        parameters.add("lang", "pl");

        return requestSpecification()
                .pathParam("cityName", cityName)
                .params(parameters)
                .get(CurrentWeatherController.CURRENT_WEATHER_URL)
                .then()
                .statusCode(HttpStatus.SERVICE_UNAVAILABLE.value())
                .and()
                .extract()
                .as(ExceptionMessage.class);
    }
}

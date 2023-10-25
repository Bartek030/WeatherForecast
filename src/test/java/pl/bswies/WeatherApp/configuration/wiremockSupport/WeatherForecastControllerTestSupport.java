package pl.bswies.WeatherApp.configuration.wiremockSupport;

import io.restassured.specification.RequestSpecification;
import org.springframework.http.HttpStatus;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.bswies.WeatherApp.api.WeatherForecastController;
import pl.bswies.WeatherApp.api.dto.ExceptionMessage;
import pl.bswies.WeatherApp.business.models.WeatherForecastData;

public interface WeatherForecastControllerTestSupport {

    RequestSpecification requestSpecification();

    default WeatherForecastData getForecastData(final String cityName) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("units", "metric");
        parameters.add("lang", "pl");

        return requestSpecification()
                .pathParam("cityName", cityName)
                .params(parameters)
                .get(WeatherForecastController.WEATHER_FORECAST_URL)
                .then()
                .statusCode(HttpStatus.OK.value())
                .and()
                .extract()
                .as(WeatherForecastData.class);
    }

    default ExceptionMessage throwExceptionWhileTryingToGetForecastData(final String cityName) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("units", "metric");
        parameters.add("lang", "pl");

        return requestSpecification()
                .pathParam("cityName", cityName)
                .params(parameters)
                .get(WeatherForecastController.WEATHER_FORECAST_URL)
                .then()
                .statusCode(HttpStatus.SERVICE_UNAVAILABLE.value())
                .and()
                .extract()
                .as(ExceptionMessage.class);
    }
}

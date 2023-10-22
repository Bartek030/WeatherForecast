package pl.bswies.WeatherApp.configuration.wiremockSupport;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.matching.StringValuePattern;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public interface WireMockTestSupport {

    default void stubForCurrentWeather(final WireMockServer wireMockServer, final String cityName) {
        Map<String, StringValuePattern> parameters = Map.of(
                "units", equalTo("metric"),
                "lang", equalTo("pl"),
                "q", equalTo(cityName)
        );

        wireMockServer.stubFor(get(urlPathEqualTo("/data/2.5/weather"))
                .withQueryParams(parameters)
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/weatherData-1.json")));

    }

    default void stubForWeatherForecast(final WireMockServer wireMockServer, final String cityName) {
        Map<String, StringValuePattern> parameters = Map.of(
                "units", equalTo("metric"),
                "lang", equalTo("pl"),
                "q", equalTo(cityName)
        );

        wireMockServer.stubFor(get(urlPathEqualTo("/data/2.5/forecast"))
                .withQueryParams(parameters)
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/forecastData-1.json")));

    }
}

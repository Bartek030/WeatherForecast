package pl.bswies.WeatherApp.configuration.wiremockSupport;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public interface WireMockTestSupport {

    default void stubForCurrentWeather(final WireMockServer wireMockServer, final String cityName) {
        wireMockServer.stubFor(get(urlPathEqualTo("/data/2.5/weather"))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/weatherData-1.json")));

    }

    default void stubForWeatherForecast(final WireMockServer wireMockServer, final String cityName) {
        wireMockServer.stubFor(get(urlPathEqualTo("/data/2.5/forecast"))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile("wiremock/weatherData-1.json")));

    }
}

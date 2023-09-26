package pl.bswies.WeatherApp.business.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bswies.WeatherApp.business.models.WeatherForecastData;
import pl.bswies.WeatherApp.business.services.WeatherForecastService;

@Service
@RequiredArgsConstructor
public class WeatherForecastServiceImpl implements WeatherForecastService {

    public static final Integer NUMBER_OF_FORECASTED_DAYS = 7;

    private final WebClient webClient;

    @Value("${api.open-weather-map.apiKey}")
    private String apiKey;

    @Override
    public WeatherForecastData getWeatherForecastData(final String cityName, final String units, final String lang) {
        final String apiAddress = "/data/2.5/forecast?appid=" + apiKey + "&lang="
                + lang + "&units=" + units + "&q=" + cityName + "&cnt=" + NUMBER_OF_FORECASTED_DAYS;
        try {

            return webClient.get()
                    .uri(apiAddress)
                    .retrieve()
                    .bodyToMono(WeatherForecastData.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Weather data cannot be retrieved");
        }
    }
}

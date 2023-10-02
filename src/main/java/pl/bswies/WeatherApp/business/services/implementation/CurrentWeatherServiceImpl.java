package pl.bswies.WeatherApp.business.services.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pl.bswies.WeatherApp.business.models.WeatherData;
import pl.bswies.WeatherApp.business.services.CurrentWeatherService;

@Service
@RequiredArgsConstructor
public class CurrentWeatherServiceImpl implements CurrentWeatherService {

    @Value("${api.open-weather-map.apiKey}")
    private String apiKey;

    private final WebClient webClient;

    @Override
    public WeatherData getCurrentWeatherData(final String cityName, final String units, final String lang) {
        try {
            return webClient.get()
                    .uri("/data/2.5/weather?appid=" + apiKey + "&lang=" + lang + "&units=" + units + "&q=" + cityName)
                    .retrieve()
                    .bodyToMono(WeatherData.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Weather data cannot be retrieved");
        }
    }
}

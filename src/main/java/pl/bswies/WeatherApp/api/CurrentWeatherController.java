package pl.bswies.WeatherApp.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bswies.WeatherApp.business.models.WeatherData;
import pl.bswies.WeatherApp.business.services.CurrentWeatherService;

@RestController
@AllArgsConstructor
@RequestMapping(CurrentWeatherController.CURRENT_WEATHER_URL)
public class CurrentWeatherController {

    public static final String CURRENT_WEATHER_URL = "/current/{cityName}";

    private final CurrentWeatherService currentWeatherService;

    @GetMapping
    public ResponseEntity<WeatherData> getCurrentWeatherData(
            @PathVariable String cityName,
            @RequestParam String units,
            @RequestParam String lang
    ) {
        WeatherData weatherData = currentWeatherService.getCurrentWeatherData(cityName, units, lang);
        return ResponseEntity.ok(weatherData);
    }
}

package pl.bswies.WeatherApp.api;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bswies.WeatherApp.business.models.WeatherForecastData;
import pl.bswies.WeatherApp.business.services.WeatherForecastService;

@RestController
@AllArgsConstructor
@RequestMapping(WeatherForecastController.WEATHER_FORECAST_URL)
public class WeatherForecastController {

    public static final String WEATHER_FORECAST_URL = "/forecast/{cityName}";

    private final WeatherForecastService weatherForecastService;

    @GetMapping
    public ResponseEntity<WeatherForecastData> getWeatherForecastData(
            @PathVariable String cityName,
            @Parameter(description = "standerd, metric or imperial")
            @RequestParam String units,
            @Parameter(description = "Language in short form - for example: en")
            @RequestParam String lang
    ) {
        final WeatherForecastData weatherForecastData =
                weatherForecastService.getWeatherForecastData(cityName, units, lang);
        return ResponseEntity.ok(weatherForecastData);
    }
}

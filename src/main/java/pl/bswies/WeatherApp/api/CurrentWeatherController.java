package pl.bswies.WeatherApp.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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

    @Operation(summary = "Get Current Weather Data for specified city")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Current weather data was found",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = WeatherData.class
                                    )
                            )
                    }),
            @ApiResponse(
                    responseCode = "503",
                    description = "Server unavailable",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<WeatherData> getCurrentWeatherData(
            @PathVariable String cityName,
            @Parameter(description = "standerd, metric or imperial")
            @RequestParam String units,
            @Parameter(description = "Language in short form - for example: en")
            @RequestParam String lang
    ) {
        WeatherData weatherData = currentWeatherService.getCurrentWeatherData(cityName, units, lang);
        return ResponseEntity.ok(weatherData);
    }
}

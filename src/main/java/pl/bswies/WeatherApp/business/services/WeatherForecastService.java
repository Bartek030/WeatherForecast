package pl.bswies.WeatherApp.business.services;

import pl.bswies.WeatherApp.business.models.WeatherForecastData;

public interface WeatherForecastService {
    WeatherForecastData getWeatherForecastData(final String cityName, final String units, final String lang);
}

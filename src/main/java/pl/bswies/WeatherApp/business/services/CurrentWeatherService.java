package pl.bswies.WeatherApp.business.services;

import pl.bswies.WeatherApp.business.models.CurrentWeatherData;

public interface CurrentWeatherService {
    CurrentWeatherData getCurrentWeatherData(final String cityName, final String units, final String lang);
}

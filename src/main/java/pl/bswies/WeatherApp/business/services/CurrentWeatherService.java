package pl.bswies.WeatherApp.business.services;

import pl.bswies.WeatherApp.business.models.WeatherData;

public interface CurrentWeatherService {
    WeatherData getCurrentWeatherData(final String cityName, final String units, final String lang);
}

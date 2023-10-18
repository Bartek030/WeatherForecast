package pl.bswies.WeatherApp.business.exceptions;

public class WeatherDataNotFoundException extends RuntimeException {

    public WeatherDataNotFoundException(final String message) {
        super(message);
    }
}

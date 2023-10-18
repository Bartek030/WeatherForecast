package pl.bswies.WeatherApp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pl.bswies.WeatherApp.business.exceptions.WeatherDataNotFoundException;
import pl.bswies.WeatherApp.business.models.WeatherForecastData;
import pl.bswies.WeatherApp.business.services.WeatherForecastService;
import pl.bswies.WeatherApp.util.WeatherForecastDataExample;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = WeatherForecastController.class)
@AutoConfigureMockMvc(addFilters = false)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class WeatherForecastControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private WeatherForecastService weatherForecastService;

    @Test
    void getWeatherForecastShouldReturnDataCorrectly() throws Exception {
        // given
        String cityName = "Warszawa";
        WeatherForecastData weatherForecastData = WeatherForecastDataExample.someWeatherForecastData1();
        String responseBody = objectMapper.writeValueAsString(weatherForecastData);

        when(weatherForecastService.getWeatherForecastData(anyString(), anyString(), anyString()))
                .thenReturn(weatherForecastData);

        // when then
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("units", "metric");
        parameters.add("lang", "pl");
        String endpoint = WeatherForecastController.WEATHER_FORECAST_URL;

        final MvcResult result = mockMvc.perform(get(endpoint, cityName)
                        .params(parameters))
                .andExpect(status().isOk())
                .andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8))
                .isEqualTo(responseBody);
    }

    @Test
    void getWeatherForecastShouldThrownException() throws Exception {
        // given
        String cityName = "Warszawa";
        final String errorMessage = "Weather data cannot be retrieved";

        when(weatherForecastService.getWeatherForecastData(anyString(), anyString(), anyString()))
                .thenThrow(new WeatherDataNotFoundException(errorMessage));

        // when then
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("units", "metric");
        parameters.add("lang", "pl");
        String endpoint = WeatherForecastController.WEATHER_FORECAST_URL;

        mockMvc.perform(get(endpoint, cityName)
                        .params(parameters))
                .andExpect(status().isServiceUnavailable())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof WeatherDataNotFoundException))
                .andExpect(result ->
                        assertEquals(errorMessage, Objects.requireNonNull(result.getResolvedException()).getMessage()));

    }

}
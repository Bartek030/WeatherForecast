package pl.bswies.WeatherApp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.bswies.WeatherApp.business.models.WeatherData;
import pl.bswies.WeatherApp.business.services.CurrentWeatherService;
import pl.bswies.WeatherApp.util.WeatherDataExample;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CurrentWeatherController.class)
@AutoConfigureMockMvc(addFilters = false)
@AllArgsConstructor
class CurrentWeatherControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private CurrentWeatherService currentWeatherService;

    @Test
    void getCurrentWeatherDataShouldReturnDataCorrectly() throws Exception {
        // given
        String cityName = "Warszawa";
        WeatherData weatherData = WeatherDataExample.someWeatherData1();

        when(currentWeatherService.getCurrentWeatherData(anyString(), anyString(), anyString()))
                .thenReturn()

        // when then
        String endpoint = CurrentWeatherController.CURRENT_WEATHER_URL;
        mockMvc.perform(get(endpoint, cityName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$."))

    }
}
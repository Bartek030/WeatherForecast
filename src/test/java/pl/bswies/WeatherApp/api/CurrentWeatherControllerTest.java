package pl.bswies.WeatherApp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.bswies.WeatherApp.business.services.CurrentWeatherService;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = CurrentWeatherController.class)
@AutoConfigureMockMvc(addFilters = false)
@AllArgsConstructor
class CurrentWeatherControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private CurrentWeatherService currentWeatherService;

    @Test
    void
}
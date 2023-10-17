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
import pl.bswies.WeatherApp.business.models.WeatherData;
import pl.bswies.WeatherApp.business.services.CurrentWeatherService;
import pl.bswies.WeatherApp.util.WeatherDataExample;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CurrentWeatherController.class)
@AutoConfigureMockMvc(addFilters = false)
@AllArgsConstructor(onConstructor = @__(@Autowired))
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
        String responseBody = objectMapper.writeValueAsString(weatherData);

        when(currentWeatherService.getCurrentWeatherData(anyString(), anyString(), anyString()))
                .thenReturn(weatherData);

        // when then
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("units", "metric");
        parameters.add("lang", "pl");
        String endpoint = CurrentWeatherController.CURRENT_WEATHER_URL;

        final MvcResult result = mockMvc.perform(get(endpoint, cityName)
                        .params(parameters))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.visibility", is(10000)))
                .andExpect(jsonPath("$.name", is("Stuttgart")))
                .andExpect(jsonPath("$.dt", is(1696876829)))
                .andReturn();

        assertThat(result.getResponse().getContentAsString(StandardCharsets.UTF_8))
                .isEqualTo(responseBody);
    }
}
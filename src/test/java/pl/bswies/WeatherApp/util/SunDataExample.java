package pl.bswies.WeatherApp.util;

import lombok.experimental.UtilityClass;
import pl.bswies.WeatherApp.business.models.SunData;

@UtilityClass
public class SunDataExample {

    public SunData someSunData1() {
        return SunData.builder()
                .sunrise(1696829617)
                .sunset(1696870047)
                .build();

    }

    public SunData someSunData2() {
        return SunData.builder()
                .sunrise(1696884155)
                .sunset(1696925640)
                .build();

    }

    public SunData someSunData3() {
        return SunData.builder()
                .sunrise(1696843164)
                .sunset(1696887299)
                .build();

    }
}

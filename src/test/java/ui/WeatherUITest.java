package ui;

import api.models.WeatherResponse;
import org.junit.Before;
import org.junit.Test;
import ui.steps.ForecastSteps;
import ui.steps.HomeSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class WeatherUITest extends UiTestBase {

    private HomeSteps homeSteps;
    private ForecastSteps forecastSteps;

    @Before
    public void prepare() throws InterruptedException {
        homeSteps = new HomeSteps(driver);
        forecastSteps = new ForecastSteps(driver);
    }

    @Test
    public void verifyTemperatureInComparisonWithWeatherCom() {
        WeatherResponse weatherResponse = REQUEST.given().param("q", "Pushcha-Voditsa").get().as(WeatherResponse.class);
        homeSteps.setLocation("Pushcha-Voditsa");
        double temperature = Double.parseDouble(forecastSteps.getTemperature().replace("°", ""));
        assertThat("Openweathermap temperature is higher than weather.com - 1",
                weatherResponse.getMain().getTemp(), greaterThanOrEqualTo(temperature - 1));
        assertThat("Openweathermap temperature is lower than weather.com + 1",
                weatherResponse.getMain().getTemp(), lessThanOrEqualTo(temperature + 1));
    }
}

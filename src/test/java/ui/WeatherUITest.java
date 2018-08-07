package ui;

import api.TestBase;
import api.models.WeatherResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import ui.pages.Forecast;
import ui.steps.HomeSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class WeatherUITest extends TestBase {

    private static HomeSteps homeSteps;

    @BeforeClass
    public static void prepare() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        homeSteps = new HomeSteps();
    }

    @Test
    public void verifyTemperatureInComparisonWithWeatherCom() {
        WeatherResponse weatherResponse = REQUEST.given().param("q", "Pushcha-Voditsa").get().as(WeatherResponse.class);
        Forecast forecast = homeSteps.setLocation("Pushcha-Voditsa");
        double temperature = Double.parseDouble(forecast.getTemperature().replace("°", ""));
        assertThat(weatherResponse.getMain().getTemp(), greaterThanOrEqualTo(temperature - 1));
        assertThat(weatherResponse.getMain().getTemp(), lessThanOrEqualTo(temperature + 1));
    }
}

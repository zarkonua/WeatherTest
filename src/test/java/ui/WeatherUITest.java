package ui;

import api.TestBase;
import api.models.WeatherResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import ui.pages.Forecast;
import ui.pages.Home;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class WeatherUITest extends TestBase {

    private static Home home;

    @BeforeClass
    public static void prepare() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        home = new Home();
    }

    @Test
    public void verifyTemperatureInComparisonWithWeatherCom() {
        WeatherResponse weatherResponse = REQUEST.given().param("q", "Pushcha-Voditsa").get().as(WeatherResponse.class);
        home.open();
        Forecast forecast = home.setLocation("Pushcha-Voditsa");
        double temperature = Double.parseDouble(forecast.getTemperature().replace("°", ""));
        assertThat(weatherResponse.getMain().getTemp(), greaterThanOrEqualTo(temperature - 1));
        assertThat(weatherResponse.getMain().getTemp(), lessThanOrEqualTo(temperature + 1));
    }
}

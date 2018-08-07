package ui.steps;

import org.openqa.selenium.WebDriver;
import ui.pages.Forecast;

public class ForecastSteps {

    private Forecast forecast;

    public ForecastSteps(WebDriver driver) {
        forecast = new Forecast(driver);
    }

    public String getTemperature() {
        return forecast.getTemperatureElement().getText();
    }
}

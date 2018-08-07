package ui.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.Forecast;

public class ForecastSteps {

    private Forecast forecast;
    private WebDriverWait wait;

    public ForecastSteps(WebDriver driver) {
        forecast = new Forecast(driver);
        wait = new WebDriverWait(driver, 30);
    }

    public String getTemperature() {
        return wait.until(ExpectedConditions.elementToBeClickable(forecast.getTemperatureElement())).getText();
    }
}

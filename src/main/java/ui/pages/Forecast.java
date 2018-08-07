package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forecast extends PageBase {

    public Forecast(WebDriver driver) {
        super(driver);
    }

    public WebElement getTemperatureElement() {
        return $(By.xpath("//*[@id=\"APP\"]/div/div[9]/div[2]/div[3]/main/div[2]/section/div[2]/div[1]/div[2]/span"));
    }

}
package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Forecast extends ParentPage {

    public Forecast(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait wait = new WebDriverWait(driver, 30);

    public String getTemperature() {
        String searchInputElementExpression = "//*[@id=\"APP\"]/div/div[9]/div[2]/div[3]/main/div[2]/section/div[2]/div[1]/div[2]/span";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchInputElementExpression)));
        String temperature = $(By.xpath(searchInputElementExpression)).getText();
        System.out.println(temperature);
        return temperature;
    }

}
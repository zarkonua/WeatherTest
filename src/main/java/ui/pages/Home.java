package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends ParentPage {

    private static final String URl = "http://weather.com";
    private WebDriverWait wait = new WebDriverWait(driver, 30);

    public void open() {
        open(URl);
    }

    public Forecast setLocation(String location) {
        String searchInputElementExpression = "//*[@id=\"APP\"]/div/div[7]/div[1]/div/div[1]/div/div[1]/div/input";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchInputElementExpression)));
        $(By.xpath(searchInputElementExpression)).sendKeys(location);
        String searchResultsExpression = "//*[@id=\"APP\"]/div/div[7]/div[1]/div/div[1]/div/div[2]/div[2]/div/ul/li/a";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResultsExpression)));
        $(By.xpath(searchResultsExpression)).click();
        return new Forecast(driver);
    }

}
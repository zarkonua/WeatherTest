package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends PageBase {

    private static final String URl = "http://weather.com";
    private WebDriverWait wait = new WebDriverWait(driver, 30);
    private String searchInputElementExpression = "//*[@id=\"APP\"]/div/div[7]/div[1]/div/div[1]/div/div[1]/div/input";

    public Home(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open(URl);
    }

    public void getSearchInputElement() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchInputElementExpression)));
    }

    public void fillInSearchForm(String location) {
        $(By.xpath(searchInputElementExpression)).sendKeys(location);
    }

    public void clickOnSearchResult() {
        String searchResultsExpression = "//*[@id=\"APP\"]/div/div[7]/div[1]/div/div[1]/div/div[2]/div[2]/div/ul/li/a";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchResultsExpression)));
        $(By.xpath(searchResultsExpression)).click();
    }

}
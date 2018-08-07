package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home extends PageBase {

    private static final String URl = "http://weather.com";
    private String searchInputElementExpression = "//*[@id=\"APP\"]/div/div[7]/div[1]/div/div[1]/div/div[1]/div/input";

    public Home(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open(URl);
    }

    public WebElement getSearchInputElement() {
        return $(By.xpath(searchInputElementExpression));
    }

    public void fillInSearchForm(String location) {
        $(By.xpath(searchInputElementExpression)).sendKeys(location);
    }

    public WebElement getSearchResult() {
        return $(By.xpath("//*[@id=\"APP\"]/div/div[7]/div[1]/div/div[1]/div/div[2]/div[2]/div/ul/li/a"));
    }

}
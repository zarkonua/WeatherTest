package ui.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.Home;

public class HomeSteps {

    private Home home;
    private WebDriverWait wait;

    public HomeSteps(WebDriver driver) {
        home = new Home(driver);
        wait = new WebDriverWait(driver, 30);
    }

    public void setLocation(String location) {
        home.open();
        wait.until(ExpectedConditions.elementToBeClickable(home.getSearchInputElement()));
        home.fillInSearchForm(location);
        wait.until(ExpectedConditions.elementToBeClickable(home.getSearchResult())).click();
    }
}

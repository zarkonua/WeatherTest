package ui;

import api.ApiTestBase;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiTestBase extends ApiTestBase {

    protected static WebDriver driver;

    public UiTestBase() {
        super();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void cleanUp() {
        driver.close();
    }
}

package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator implements WebDriverCreator {
    @Override
    public WebDriver createWebDriver() {
        return new FirefoxDriver();
    }
}
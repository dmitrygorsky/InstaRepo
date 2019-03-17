package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator implements WebDriverCreator {

    @Override
    public WebDriver createWebDriver() {
        return new ChromeDriver();
    }
}
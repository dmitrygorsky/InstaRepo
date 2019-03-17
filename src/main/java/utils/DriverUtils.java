package utils;

import factory.*;
import org.openqa.selenium.WebDriver;

public class DriverUtils {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            synchronized (DriverUtils.class) {
                chooseDriver();
            }
        }
        return driver.get();
    }

    public static void chooseDriver() {
        String browser = System.getProperty("browser").toLowerCase();
        String launcher = System.getProperty("launcher");
        WebDriverCreator creator;
        if (launcher.equalsIgnoreCase("local")) {
            switch (browser) {
                case "chrome":
                    creator = new ChromeDriverCreator();
                    break;
                case "firefox":
                    creator = new FirefoxDriverCreator();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type - " + browser);
            }
        } else {
            throw new IllegalArgumentException("Incorrect launch space - " + launcher);
        }
        driver.set(creator.createWebDriver());

    }

    public static void clearThreadLocal() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

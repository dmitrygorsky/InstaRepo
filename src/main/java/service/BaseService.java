package service;

import org.openqa.selenium.WebDriver;
import utils.DriverUtils;

public class BaseService {

    private WebDriver driver;
    private static final String credentials = "src/main/resources/user.properties";

    public BaseService() {
        this.driver = DriverUtils.getDriver();
    }

    public static String getCredentials() {
        return credentials;
    }

}
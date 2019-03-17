package page;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

public class LoginPage extends BasePage {

    private static final String LOGIN_LINK_LOCATOR = "//a[contains(text(),'Log in')]";
    private static final String LOGIN_BUTTON_LOCATOR = "[type='submit']";
    private static final String DISABLED_LOGIN_BUTTON_LOCATOR = "//button[@disabled]";
    @FindBy(xpath = LOGIN_LINK_LOCATOR)
    private static WebElement loginLink;
    @FindBy(name = "username")
    private static WebElement loginField;
    @FindBy(name = "password")
    private static WebElement passwordField;
    @FindBy(css = LOGIN_BUTTON_LOCATOR)
    private static WebElement loginButton;
    @FindBy(id = "slfErrorAlert")
    private static WebElement errorMessageLabel;

    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getErrorMessageLabel() {
        return errorMessageLabel;
    }

    public LoginPage typeLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void waitForLoginLinkToDisappear() {
        new WebDriverWait(DriverUtils.getDriver(), EXPLICITLY_WAIT_FOR_ELEMENT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOGIN_LINK_LOCATOR)));
    }

    public void waitForLoginLinkToAppear() {
        new WebDriverWait(DriverUtils.getDriver(), EXPLICITLY_WAIT_FOR_ELEMENT).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_LINK_LOCATOR)));
    }

    public void waitForLoginButtonToBeEnabled() {
        new WebDriverWait(DriverUtils.getDriver(), EXPLICITLY_WAIT_FOR_ELEMENT).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DISABLED_LOGIN_BUTTON_LOCATOR)));
    }

}

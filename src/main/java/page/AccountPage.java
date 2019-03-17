package page;

import basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;
import utils.PropertyUtils;

import java.util.List;
import java.util.NoSuchElementException;

public class AccountPage extends BasePage {

    private static final String CURRENT_USER_BUTTON_LOCATOR = "//span[contains(@class,'SpriteUser')]";
    private static final String USER_SETTINGS_COG_LOCATOR = "//span[contains(@class,'SpriteSettings')]/parent::button";
    private static final String LOGOUT_BUTTON_LOCATOR = "//div[@role='dialog']//button[contains(text(),'Log Out')]";
    private static final String USER_POSTS_LOCATOR = "//div[@style and not(@class) and not(@role)]/div//a/parent::div";
    private static final String SINGLE_POST_WINDOW_LOCATOR = "//div[@role='dialog']/article";
    private static final String DIALOG_WINDOW_LOCATOR = "//div[@role='dialog']";
    private static final String SUGGESTED_DROPDOWN_ARROW_LOCATOR = "//div[contains(@class,'DropdownArrowWhite')]";
    private static final String COMMENT_FIELD_LOCATOR = "//textarea[@placeholder]";
    private static final String MORE_OPTIONS_BUTTON_LOCATOR = "//span[@aria-label='More options']/parent::button";
    private static final String REMOVE_COMMENTS_BUTTON_LOCATOR = "//div[@role='dialog']//button[contains(text(),'Remove comments')]";
    private static final String DELETE_COMMENT_BUTTON_LOCATOR = "button[title='Delete Comment']";
    private static final String DELETE_COMMENT_DIALOG_BUTTON_LOCATOR = "//button[@tabindex and contains(text(),'Delete Comment')]";
    private static final String COMMENT_BUTTON_LOCATOR = "//span[@aria-label='Comment']/parent::button";
    private static final String DATE_TIME_LOCATOR = "time[datetime]";
    @FindBy(xpath = CURRENT_USER_BUTTON_LOCATOR)
    private WebElement currentUserButton;
    @FindBy(xpath = USER_SETTINGS_COG_LOCATOR)
    private WebElement userSettingsCog;
    @FindBy(xpath = LOGOUT_BUTTON_LOCATOR)
    private WebElement logoutButton;
    @FindBy(xpath = SINGLE_POST_WINDOW_LOCATOR)
    private WebElement singlePostWindow;
    @FindBy(xpath = "//button[contains(text(),'Close')]")
    private WebElement closeButton;
    @FindBy(xpath = DIALOG_WINDOW_LOCATOR)
    private WebElement dialogWindow;
    @FindBy(xpath = USER_POSTS_LOCATOR)
    private List<WebElement> userPosts;
    @FindBy(xpath = COMMENT_FIELD_LOCATOR)
    private WebElement commentField;
    @FindBy(xpath = MORE_OPTIONS_BUTTON_LOCATOR)
    private WebElement moreOptionsButton;
    @FindBy(xpath = REMOVE_COMMENTS_BUTTON_LOCATOR)
    private WebElement removeCommentsButton;
    @FindBy(css = DELETE_COMMENT_BUTTON_LOCATOR)
    private WebElement deleteCommentButton;
    @FindBy(xpath = DELETE_COMMENT_DIALOG_BUTTON_LOCATOR)
    private WebElement deleteCommentDialogButton;
    @FindBy(xpath = COMMENT_BUTTON_LOCATOR)
    private WebElement commentButton;
    @FindBy(css = DATE_TIME_LOCATOR)
    private WebElement dateTime;

    public WebElement getLikeButton() {
        return DriverUtils.getDriver().findElement(By.xpath(SINGLE_POST_WINDOW_LOCATOR
                + "//div/section//button[contains(@class,'SpriteHeart')]"));
    }

    public WebElement getLikeHeart() {
        return DriverUtils.getDriver().findElement(By.xpath(SINGLE_POST_WINDOW_LOCATOR
                + "//div/section//button/span[contains(@class,'SpriteHeart')]"));
    }

    public WebElement getCommentLeftBySpecificUser() {
        return DriverUtils.getDriver().findElement(By.xpath(String
                .format("//li//h3//a[contains(@title,'%s')]",
                        PropertyUtils.getProperties("currentuser", accountname))));
    }

    public List<WebElement> getUserPosts() {
        return userPosts;
    }

    public WebElement getCurrentUserButton() {
        return currentUserButton;
    }

    public WebElement getUserSettingsCog() {
        return userSettingsCog;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getSinglePostWindow() {
        return singlePostWindow;
    }

    public WebElement getCloseButton() {
        return closeButton;
    }

    public WebElement getMoreOptionsButton() {
        return moreOptionsButton;
    }

    public WebElement getRemoveCommentsButton() {
        return removeCommentsButton;
    }

    public WebElement getDeleteCommentButton() {
        return deleteCommentButton;
    }

    public WebElement getDeleteCommentDialogButton() {
        return deleteCommentDialogButton;
    }

    public WebElement getCommentButton() {
        return commentButton;
    }

    public WebElement getDateTime() {
        return dateTime;
    }

    public void clickMoreOptionsButton() {
        moreOptionsButton.click();
    }

    public void clickRemoveCommentsButton() {
        removeCommentsButton.click();
    }

    public void clickDeleteCommentButton() {
        deleteCommentButton.click();
    }

    public void clickDeleteCommentDialogButton() {
        deleteCommentDialogButton.click();
    }

    public void clickCommentButton() {
        commentButton.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public void clickCurrentUserButton() {
        currentUserButton.click();
    }

    public void clickUserSettingsCog() {
        userSettingsCog.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public void clickDateTime() {
        dateTime.click();
    }

    public WebElement getDialogWindow() {
        return dialogWindow;
    }

    public WebElement getCommentField() {
        return commentField;
    }

    public void clickCommentField() {
        commentField.click();
    }

    public void typeComment(String comment) {
        commentField.sendKeys(comment);
    }

    public String getDialogWindowText() {
        return DriverUtils.getDriver().findElement(By.xpath(DIALOG_WINDOW_LOCATOR + "//h2")).getText();
    }

    public WebElement getNotNowButton() {
        return DriverUtils.getDriver()
                .findElement(By.xpath(DIALOG_WINDOW_LOCATOR + "//button[contains(text(),'Not Now')]"));
    }

    public void clickNotNowButton() {
        getNotNowButton().click();
    }

    public void waitForCurrentUserButton() {
        new WebDriverWait(DriverUtils.getDriver(), EXPLICITLY_WAIT_FOR_ELEMENT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CURRENT_USER_BUTTON_LOCATOR)));
    }

    public void waitForSuggestedDropdownArrowToAppear() {
        new WebDriverWait(DriverUtils.getDriver(), EXPLICITLY_WAIT_FOR_ELEMENT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SUGGESTED_DROPDOWN_ARROW_LOCATOR)));
    }

    public void waitForCommentToAppear() {
        new WebDriverWait(DriverUtils.getDriver(), EXPLICITLY_WAIT_FOR_ELEMENT)
                .until(ExpectedConditions.visibilityOfAllElements(getCommentLeftBySpecificUser()));
    }

    public void waitForSinglePostWindowToAppear() {
        new WebDriverWait(DriverUtils.getDriver(), EXPLICITLY_WAIT_FOR_ELEMENT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SINGLE_POST_WINDOW_LOCATOR)));
    }

    public void waitForCommentFieldToBeClickable() {
        new WebDriverWait(DriverUtils.getDriver(), EXPLICITLY_WAIT_FOR_ELEMENT)
                .until(ExpectedConditions.elementToBeClickable(singlePostWindow));
    }

    public void scrollWindow() {
        javascriptExecutor = getJavascriptExecutor();
        javascriptExecutor.executeScript("window.scrollBy(0,250)");
    }

    public void scrollToSpecificElement() {
        javascriptExecutor = getJavascriptExecutor();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", getCommentLeftBySpecificUser());
    }

    public void scrollToTheBottomOfThePage() {
        javascriptExecutor = getJavascriptExecutor();
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}

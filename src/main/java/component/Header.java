package component;

import basepage.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;
import utils.PropertyUtils;

public class Header extends AbstractPage {

    private static final String SEARCH_BUTTON_LOCATOR =
            "//span[contains(@class,'coreSpriteSearchIcon')]/ancestor::div[@role='button']";
    private static final String SEARCH_RESULTS_LOCATOR = "//div[@role='button']/ancestor::div/a";
    @FindBy(xpath = SEARCH_BUTTON_LOCATOR)
    private static WebElement searchButton;
    @FindBy(css = "[type='text']")
    private static WebElement searchField;

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getFirstFoundUserpic() {
        return DriverUtils.getDriver().findElement(By.xpath(String
                .format("(//span[contains(text(),'%s')]/ancestor::div//div[@role='button'])[1]",
                        PropertyUtils.getProperties("target",target))));
    }

    public void typeIntoSearchField(String query) {
        searchField.sendKeys(query);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickFirstFoundUserpic() {
        getFirstFoundUserpic().click();
    }

    public void waitForSearchResultsToAppear() {
        new WebDriverWait(DriverUtils.getDriver(), EXPLICITLY_WAIT_FOR_ELEMENT)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_RESULTS_LOCATOR)));
    }
}
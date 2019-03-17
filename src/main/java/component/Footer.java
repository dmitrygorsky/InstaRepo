package component;

import basepage.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class Footer extends AbstractPage{

    @FindBy(css = "nav li:last-child span")
    private static WebElement languageDropdownLabel;
    @FindBy(css = "nav li:last-child select")
    private static WebElement languageDropdown;

    public Select getLanguageDropdown() {
        WebElement langDropdown = languageDropdown;
        Select dropdown = new Select(langDropdown);
        return dropdown;
    }

    public String getCurrentLanguage() {
        return languageDropdownLabel.getText();
    }


}

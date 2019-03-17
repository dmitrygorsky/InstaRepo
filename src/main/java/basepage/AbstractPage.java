package basepage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.DriverUtils;

public class AbstractPage {

    private WebDriver driver;
    protected JavascriptExecutor javascriptExecutor;
    protected static final int EXPLICITLY_WAIT_FOR_ELEMENT = 5;
    protected static final String target = "src/main/resources/target.properties";
    protected static final String accountname = "src/main/resources/accountname.properties";

    public AbstractPage() {
        this.driver = DriverUtils.getDriver();
        PageFactory.initElements(driver, this);
    }

    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) driver;
    }

    public void waitUntilPageIsLoaded() {
        javascriptExecutor = getJavascriptExecutor();
        javascriptExecutor.executeScript("return document.readyState").toString().equals("complete");
    }

    public void zoomIn() {
        javascriptExecutor = getJavascriptExecutor();
        javascriptExecutor.executeScript("document.body.style.zoom = '2'");
    }

}
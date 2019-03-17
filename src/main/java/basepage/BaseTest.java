package basepage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import page.*;
import service.*;
import utils.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static final String target = "src/main/resources/target.properties";
    protected final String testSubject = PropertyUtils.getProperties("target",target);
    protected final String comment = "I really love automation testing";
    private final String INSTAGRAM = "https://www.instagram.com/accounts/login/?source=auth_switcher";
    private final int IMPLICIT_WAIT = 3;
    protected SoftAssert softAssert = new SoftAssert();
    protected LoginPage loginPage;
    protected String login;
    protected String correctPassword;
    protected LanguageService languageService;
    protected LikeService likeService;
    protected LoginService loginService;
    protected SearchService searchService;
    protected DialogService dialogService;
    protected AccountPage accountPage;
    protected CommentService commentService;
    private WebDriver driver;

    @BeforeMethod
    public void initApp() {
        driver = DriverUtils.getDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(INSTAGRAM);
        loginPage = new LoginPage();
        login = PropertyUtils.getProperties("login", BaseService.getCredentials());
        correctPassword = PropertyUtils.getProperties("password", BaseService.getCredentials());
        languageService = new LanguageService();
        likeService = new LikeService();
        loginService = new LoginService();
        searchService = new SearchService();
        dialogService = new DialogService();
        commentService = new CommentService();
        accountPage = new AccountPage();
    }


    @DataProvider(name = "LoginTestProvider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"", "Enter a password"},
                {"IncorrectPassword", "Wrong password. Try again or click Forgot password to reset it."},
        };
    }


    @AfterMethod
    public void killApp() {
        DriverUtils.clearThreadLocal();
    }

}


import basepage.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class InstaTest extends BaseTest {

    @Test
    public void likeNewPosts() {
        languageService.changeLanguageToEnglish();
        loginService.signIn();
        loginPage.waitUntilPageIsLoaded();
        accountPage.waitForCurrentUserButton();
        dialogService.skipNoticiationsDialog();
        searchService.searchForSpecificUser(testSubject);
        //accountPage.header.clickSearchButton();
        //accountPage.header.getSearchField().sendKeys(Keys.PAGE_DOWN);
        accountPage.waitForSuggestedDropdownArrowToAppear();
        likeService.likeAllVisiblePosts();
        loginService.signOut();
    }

    @Test
    public void unlikeNewPosts() {
        languageService.changeLanguageToEnglish();
        loginService.signIn();
        loginPage.waitUntilPageIsLoaded();
        accountPage.waitForCurrentUserButton();
        dialogService.skipNoticiationsDialog();
        searchService.searchForSpecificUser(testSubject);
        accountPage.waitForSuggestedDropdownArrowToAppear();
        likeService.unlikeAllVisiblePosts();
        loginService.signOut();
    }

    @Test
    public void commentNewPosts() {
        languageService.changeLanguageToEnglish();
        loginService.signIn();
        loginPage.waitUntilPageIsLoaded();
        accountPage.waitForCurrentUserButton();
        dialogService.skipNoticiationsDialog();
        searchService.searchForSpecificUser(testSubject);
        accountPage.waitForSuggestedDropdownArrowToAppear();
        commentService.commentAllVisiblePosts();
        loginService.signOut();
    }

    @Test
    public void removeComments() {
        languageService.changeLanguageToEnglish();
        loginService.signIn();
        loginPage.waitUntilPageIsLoaded();
        accountPage.waitForCurrentUserButton();
        dialogService.skipNoticiationsDialog();
        searchService.searchForSpecificUser(testSubject);
        accountPage.waitForSuggestedDropdownArrowToAppear();
        commentService.removeExistingComments();
        loginService.signOut();
    }

}
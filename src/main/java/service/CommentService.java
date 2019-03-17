package service;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import page.AccountPage;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;

public class CommentService extends BaseService {

    private AccountPage accountPage;

    public void addComment(String comment) {
        accountPage = new AccountPage();
        accountPage.clickCommentButton();
        accountPage.waitForCommentFieldToBeClickable();
        accountPage.clickCommentField();
        accountPage.typeComment(comment);
        accountPage.getCommentField().sendKeys(Keys.ENTER);
        accountPage.waitForCommentToAppear();
    }

    public void commentAllVisiblePosts() {
        accountPage = new AccountPage();
        List<WebElement> userPosts = accountPage.getUserPosts();
        for (WebElement post : userPosts) {
            post.click();
            accountPage.waitForSinglePostWindowToAppear();
            addComment("Gorgeous shot! Please check out my page");
            accountPage.clickCloseButton();
        }
    }

    public void removeFirstComment() {
        accountPage = new AccountPage();
        accountPage.clickMoreOptionsButton();
        accountPage.clickRemoveCommentsButton();
        accountPage.clickDeleteCommentButton();
        accountPage.clickDeleteCommentDialogButton();
    }

    public void removeTheRestOfComments() {
        accountPage = new AccountPage();
        accountPage.clickDeleteCommentButton();
        accountPage.clickDeleteCommentDialogButton();
    }

    public void removeAllVisibleComments() {
        accountPage = new AccountPage();
        List<WebElement> userPosts = accountPage.getUserPosts();
        for (int i = 0; i < userPosts.size(); i++) {
            userPosts.get(i).click();
            if (i==0) {
                removeFirstComment();
            }
            removeTheRestOfComments();
            accountPage.clickCloseButton();
        }
    }

    public boolean isCurrentUserLeftComment() {
        accountPage = new AccountPage();
        try {
            accountPage.getCommentLeftBySpecificUser();
        } catch (NoSuchElementException nsee) {
            return false;
        }
        return true;
    }

    public void removeExistingComments() {
        accountPage = new AccountPage();
        List<WebElement> userPosts = accountPage.getUserPosts();
        int k = 0;
        for (int i = 0; i < userPosts.size(); i++) {
            userPosts.get(i).click();
            if (isCurrentUserLeftComment()) {
                k++;
                accountPage.waitForSinglePostWindowToAppear();
                accountPage.clickDateTime();
                accountPage.waitUntilPageIsLoaded();
                accountPage.zoomIn();
                accountPage.scrollToTheBottomOfThePage();
                if (k == 1) {
                    removeFirstComment();
                }
                removeTheRestOfComments();
            }
            accountPage.clickCloseButton();
        }
    }

}

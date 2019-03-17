package service;

import page.AccountPage;
import page.LoginPage;
import utils.PropertyUtils;

import java.util.NoSuchElementException;

public class LoginService extends BaseService {

    private LoginPage loginPage;
    private AccountPage accountPage;

    public void signIn() {
        loginPage = new LoginPage();
        loginPage
                .typeLogin(PropertyUtils.getProperties("login", getCredentials()))
                .typePassword(PropertyUtils.getProperties("password", getCredentials()));
        loginPage.waitForLoginButtonToBeEnabled();
        loginPage.clickLoginButton();
        //if (isErrorMessageLabelExist()) {
        //    throw new IllegalArgumentException("Username or password is wrong!");
        //}
    }

    public void signOut() {
        accountPage = new AccountPage();
        accountPage.clickCurrentUserButton();
        accountPage.clickUserSettingsCog();
        accountPage.clickLogoutButton();
    }

    public boolean isErrorMessageLabelExist() {
        loginPage = new LoginPage();
        try {
            loginPage.getErrorMessageLabel();
        } catch (NoSuchElementException nsee) {
            return false;
        }
        return true;
    }

}


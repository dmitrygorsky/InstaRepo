package service;

import page.AccountPage;

import java.util.NoSuchElementException;

public class DialogService extends BaseService {

    private AccountPage accountPage;
    private static final String notifications = "Turn on Notifications";

    public boolean isNotificationsDialogDisplayed() {
        accountPage = new AccountPage();
        try {
            accountPage.getDialogWindow();
        } catch (NoSuchElementException nsee) {
            return false;
        }
        return true;
    }

    public boolean isThisDialogNotifications() {
        accountPage = new AccountPage();
        if(isNotificationsDialogDisplayed()) {
            if (accountPage.getDialogWindowText().equalsIgnoreCase(notifications)) {
                return true;
            }
        }
        return false;
    }

    public void skipNoticiationsDialog() {
        accountPage = new AccountPage();
        if (isThisDialogNotifications()) {
            accountPage.clickNotNowButton();
        }
    }

}

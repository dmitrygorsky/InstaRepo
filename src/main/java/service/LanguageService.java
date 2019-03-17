package service;

import component.Footer;

public class LanguageService extends BaseService{

    private Footer footer;

    public boolean isLanguageEnglish() {
        footer = new Footer();
        String language = "Language";
        if (footer.getCurrentLanguage().equals(language)) {
            return true;
        }
        return false;
    }

    public void changeLanguageToEnglish() {
        if (!isLanguageEnglish()) {
            clickEnglishInLanguageDropdown();
        }
    }

    public void clickEnglishInLanguageDropdown() {
        footer.getLanguageDropdown().selectByVisibleText("English");
    }
}
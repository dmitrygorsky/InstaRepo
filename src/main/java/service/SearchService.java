package service;

import component.Header;

public class SearchService {

    private Header header;

    public void searchForSpecificUser(String query) {
        header = new Header();
        header.clickSearchButton();
        header.typeIntoSearchField(query);
        header.waitForSearchResultsToAppear();
        header.clickFirstFoundUserpic();
    }
}
package org.example.pages.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage extends BasePage {

    @AndroidFindBy(id = "org.wikipedia:id/search_src_text")
    private WebElement searchInput;

    @AndroidFindBy(id = "org.wikipedia:id/page_list_item_title")
    private List<WebElement> searchResults;

    @AndroidFindBy(id = "org.wikipedia:id/search_empty_message")
    private WebElement emptyMessage;

    public void searchFor(String query) {
        searchInput.sendKeys(query);
    }

    public void clearSearch() {
        searchInput.clear();
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }

    public void clickFirstResult() {
        if (!searchResults.isEmpty()) {
            searchResults.get(0).click();
        }
    }

    public boolean isEmptyMessageDisplayed() {
        return emptyMessage.isDisplayed();
    }
}
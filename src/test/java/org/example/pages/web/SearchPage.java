package org.example.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(how = How.CSS, using = ".mw-search-result-heading a")
    private List<WebElement> searchResults;

    @FindBy(how = How.ID, using = "firstHeading")
    private WebElement pageTitle;

    @FindBy(how = How.ID, using = "searchText")
    private WebElement searchField;

    public void waitForResults() {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
    }

    public int getSearchResultsCount() {
        return searchResults.size();
    }

    public void clickFirstResult() {
        if (!searchResults.isEmpty()) {
            searchResults.get(0).click();
        }
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public boolean isSearchFieldDisplayed() {
        return searchField.isDisplayed();
    }
}
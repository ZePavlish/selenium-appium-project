package org.example.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(how = How.ID, using = "searchInput")
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'English')]")
    private WebElement englishLanguageLink;

    @FindBy(how = How.ID, using = "js-link-box-ru")
    private WebElement russianLanguageLink;

    public void open() {
        driver.get("https://www.wikipedia.org");
        wait.until(ExpectedConditions.visibilityOf(searchInput));
    }

    public void searchFor(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
        searchButton.click();
    }

    public void switchToEnglish() {
        englishLanguageLink.click();
    }

    public void switchToRussian() {
        russianLanguageLink.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
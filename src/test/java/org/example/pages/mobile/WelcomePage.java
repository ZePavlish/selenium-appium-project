package org.example.pages.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {

    @AndroidFindBy(id = "org.wikipedia:id/fragment_onboarding_skip_button")
    private WebElement skipButton;

    @AndroidFindBy(id = "org.wikipedia:id/main_toolbar_wordmark")
    private WebElement wordmark;

    @AndroidFindBy(id = "org.wikipedia:id/search_container")
    private WebElement searchContainer;

    public void skipWelcomeScreen() {
        skipButton.click();
    }

    public boolean isMainPageDisplayed() {
        return wordmark.isDisplayed();
    }

    public void clickSearchContainer() {
        searchContainer.click();
    }
}
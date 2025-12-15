package org.example.pages.mobile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ArticlePage extends BasePage {

    @AndroidFindBy(id = "org.wikipedia:id/view_page_title_text")
    private WebElement articleTitle;

    @AndroidFindBy(id = "org.wikipedia:id/page_actions_tab_layout")
    private WebElement tabsLayout;

    @AndroidFindBy(accessibility = "More options")
    private WebElement moreOptions;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Find in page']")
    private WebElement findInPageOption;

    @AndroidFindBy(id = "org.wikipedia:id/page_toolbar_button_search")
    private WebElement searchInArticleButton;

    public String getArticleTitle() {
        return articleTitle.getText();
    }

    public boolean isArticleTitleDisplayed() {
        return articleTitle.isDisplayed();
    }

    public void scrollDown() {
        driver.executeScript("mobile: scrollGesture",
                java.util.Map.of(
                        "left", 100, "top", 300, "width", 200, "height", 600,
                        "direction", "down",
                        "percent", 1.0
                ));
    }

    public void openMoreOptions() {
        moreOptions.click();
    }

    public void clickFindInPage() {
        findInPageOption.click();
    }
}
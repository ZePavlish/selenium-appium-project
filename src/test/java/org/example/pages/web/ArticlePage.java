package org.example.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArticlePage extends BasePage {

    @FindBy(how = How.ID, using = "firstHeading")
    private WebElement articleTitle;

    @FindBy(how = How.ID, using = "ca-history")
    private WebElement historyTab;

    @FindBy(how = How.ID, using = "p-lang-btn")
    private WebElement languagesButton;

    @FindBy(how = How.XPATH, using = "//a[@lang='ru']")
    private WebElement russianLanguageLink;

    @FindBy(how = How.XPATH, using = "//div[@id='mw-content-text']//p[1]")
    private WebElement firstParagraph;

    public String getArticleTitle() {
        wait.until(ExpectedConditions.visibilityOf(articleTitle));
        return articleTitle.getText();
    }

    public void clickHistoryTab() {
        historyTab.click();
    }

    public void switchToRussianLanguage() {
        languagesButton.click();
        wait.until(ExpectedConditions.visibilityOf(russianLanguageLink));
        russianLanguageLink.click();
    }

    public String getFirstParagraphText() {
        return firstParagraph.getText();
    }

    public boolean isTitleDisplayed() {
        return articleTitle.isDisplayed();
    }
}
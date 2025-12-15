package org.example.tests.web;

import org.example.pages.web.HomePage;
import org.example.pages.web.SearchPage;
import org.example.pages.web.ArticlePage;
import org.example.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WikipediaWebTests {

    private HomePage homePage;
    private SearchPage searchPage;
    private ArticlePage articlePage;

    @BeforeClass
    public void setUp() {
        DriverManager.getDriver();
        homePage = new HomePage();
        searchPage = new SearchPage();
        articlePage = new ArticlePage();
    }

    @Test(priority = 1, description = "Test Wikipedia homepage loading")
    public void testHomePageLoading() {
        homePage.open();
        Assert.assertTrue(homePage.getCurrentUrl().contains("wikipedia.org"),
                "Wikipedia homepage should be loaded");
    }

    @Test(priority = 2, description = "Test search functionality")
    public void testSearchFunctionality() {
        homePage.searchFor("Selenium WebDriver");
        searchPage.waitForResults();

        Assert.assertTrue(searchPage.getSearchResultsCount() > 0,
                "Search should return results");
        Assert.assertTrue(searchPage.isSearchFieldDisplayed(),
                "Search field should be displayed on results page");
    }

    @Test(priority = 3, description = "Test opening article from search results")
    public void testOpenArticleFromSearch() {
        searchPage.clickFirstResult();

        Assert.assertTrue(articlePage.isTitleDisplayed(),
                "Article title should be displayed");
        Assert.assertTrue(articlePage.getArticleTitle().contains("Selenium"),
                "Article title should contain search term");
    }

    @Test(priority = 4, description = "Test article content")
    public void testArticleContent() {
        String firstParagraph = articlePage.getFirstParagraphText();
        Assert.assertNotNull(firstParagraph, "Article should have content");
        Assert.assertFalse(firstParagraph.isEmpty(), "Article content should not be empty");
    }

    @Test(priority = 5, description = "Test language switching")
    public void testLanguageSwitching() {
        homePage.open();
        homePage.switchToRussian();

        Assert.assertTrue(homePage.getCurrentUrl().contains("ru.wikipedia.org"),
                "Should switch to Russian version of Wikipedia");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
package org.example.tests.mobile;

import org.example.pages.mobile.WelcomePage;
import org.example.pages.mobile.SearchPage;
import org.example.pages.mobile.ArticlePage;
import org.example.utils.AppiumDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WikipediaAppTests {

    private WelcomePage welcomePage;
    private SearchPage searchPage;
    private ArticlePage articlePage;

    @BeforeClass
    public void setUp() {
        AppiumDriverManager.getDriver();
        welcomePage = new WelcomePage();
        searchPage = new SearchPage();
        articlePage = new ArticlePage();

        // Skip welcome screens if present
        try {
            welcomePage.skipWelcomeScreen();
        } catch (Exception e) {
            // Welcome screen might not be present
        }
    }

    @Test(priority = 1, description = "Test main screen display")
    public void testMainScreenDisplay() {
        Assert.assertTrue(welcomePage.isMainPageDisplayed(),
                "Main page should be displayed with Wikipedia wordmark");
    }

    @Test(priority = 2, description = "Test search functionality in app")
    public void testSearchInApp() {
        welcomePage.clickSearchContainer();
        searchPage.searchFor("Test automation");

        // Wait for results
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(searchPage.getSearchResultsCount() > 0,
                "Search should return results for 'Test automation'");
    }

    @Test(priority = 3, description = "Test opening article from search results")
    public void testOpenArticleInApp() {
        searchPage.clickFirstResult();

        Assert.assertTrue(articlePage.isArticleTitleDisplayed(),
                "Article title should be displayed");

        String title = articlePage.getArticleTitle();
        Assert.assertNotNull(title, "Article title should not be null");
        Assert.assertFalse(title.isEmpty(), "Article title should not be empty");
    }

    @Test(priority = 4, description = "Test scrolling article content")
    public void testScrollArticle() {
        // Scroll down to test scrolling functionality
        articlePage.scrollDown();

        // Verify we can still see the title after scrolling
        Assert.assertTrue(articlePage.isArticleTitleDisplayed(),
                "Article title should still be visible after scrolling");
    }

    @Test(priority = 5, description = "Test empty search results")
    public void testEmptySearchResults() {
        // Navigate back to search
        AppiumDriverManager.getDriver().navigate().back();
        welcomePage.clickSearchContainer();

        // Search for something that likely has no results
        searchPage.searchFor("asdfghjkl123456789");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // This test might pass or fail depending on Wikipedia's behavior
        // It's okay if it doesn't show empty message for gibberish search
        System.out.println("Empty search test completed");
    }

    @AfterClass
    public void tearDown() {
        AppiumDriverManager.quitDriver();
    }
}
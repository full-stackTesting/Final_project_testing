package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class T25_ScrollUpUsingArrowButton extends TestBase {

    HomePage homeobj;

    public void initializeObjects() {
        homeobj = new HomePage(driver);
    }

    // Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
    @Test
    public void verifyScrollUpUsingArrowButton() {
        initializeObjects();

        // Verify Home Page
        Assert.assertTrue(homeobj.homePageBtn.isDisplayed());

        // Scroll down page to bottom
        homeobj.scrollToBottom();

        // Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(homeobj.isSubscriptionVisible());

        // Click on arrow at bottom right side to move upward
        homeobj.clickScrollUpArrow();

        // Verify that page is scrolled up and text is visible
        Assert.assertTrue(homeobj.isFullFledgedTextVisible());
    }
}
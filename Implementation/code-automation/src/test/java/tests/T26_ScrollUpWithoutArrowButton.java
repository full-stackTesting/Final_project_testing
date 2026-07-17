package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class T26_ScrollUpWithoutArrowButton extends TestBase {

    HomePage homeobj;
    @Test
    public void verifyScrollUpWithoutArrowButton() throws InterruptedException {
    	 homeobj = new HomePage(driver);

        // Verify Home Page
        Assert.assertTrue(homeobj.homePageBtn.isDisplayed());

        // Scroll down page to bottom
        homeobj.scrollToBottom();
        Thread.sleep(2000);

        // Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(homeobj.isSubscriptionVisible());

        // Scroll up page to top (without arrow button)
        homeobj.scrollToTopUsingJS();
        Thread.sleep(2000);

        // Verify that page is scrolled up and text is visible
        Assert.assertTrue(homeobj.isFullFledgedTextVisible());
    }
}
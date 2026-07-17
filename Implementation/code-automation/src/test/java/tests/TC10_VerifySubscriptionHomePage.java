package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_VerifySubscriptionHomePage extends TestBase {

    @Test
    public void testSubscription_ValidEmail() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Assert.assertEquals(driver.getTitle(), "Automation Exercise");

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(2000);

        WebElement subscription = driver.findElement(
                By.xpath("//h2[contains(text(),'Subscription')]"));

        Assert.assertTrue(subscription.isDisplayed());

        WebElement email = driver.findElement(By.id("susbscribe_email"));

        email.clear();
        email.sendKeys("eng.esraamostafa50@gmail.com");

        driver.findElement(By.id("subscribe")).click();

        Thread.sleep(3000);

        List<WebElement> success = driver.findElements(
                By.xpath("//*[contains(text(),'successfully subscribed')]"));

        Assert.assertTrue(success.size() > 0);

    }
}
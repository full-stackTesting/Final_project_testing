package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11_VerifySubscriptionCartPage extends TestBase {

    @Test
    public void testSubscription_ValidEmailFromCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Assert.assertEquals(driver.getTitle(), "Automation Exercise");

        // Open Cart
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement subscription = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[contains(text(),'Subscription')]")));

        Assert.assertTrue(subscription.isDisplayed());

        WebElement email = driver.findElement(By.id("susbscribe_email"));
        email.clear();
        email.sendKeys("eng.esraamostafa50@gmail.com");

        driver.findElement(By.id("subscribe")).click();

        WebElement success = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".alert-success.alert")));

        Assert.assertTrue(success.getText().contains("successfully subscribed"));

    }
}
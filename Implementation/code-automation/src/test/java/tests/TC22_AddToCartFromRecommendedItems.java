package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC22_AddToCartFromRecommendedItems extends TestBase {

    @Test(priority = 1)
    public void testAddToCartFromRecommendedItems() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Assert.assertEquals(driver.getTitle(), "Automation Exercise");

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);

        WebElement recommended = driver.findElement(
                By.xpath("//h2[contains(text(),'recommended items')]"));

        Assert.assertTrue(recommended.isDisplayed());

        WebElement addBtn = driver.findElement(
                By.xpath("(//div[@id='recommended-item-carousel']//a[contains(text(),'Add to cart')])[1]"));

        js.executeScript("arguments[0].click();", addBtn);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        Thread.sleep(3000);

        List<WebElement> items = driver.findElements(By.xpath("//tbody/tr"));

        Assert.assertTrue(items.size() > 0);

    }
}
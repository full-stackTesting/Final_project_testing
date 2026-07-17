package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartDetailsPage;
import pages.ProductDetailsPage;

public class TC13_VerifyProductQuantityInCart extends TestBase {

    @Test
    public void testProductQuantityInCart() throws InterruptedException {

        ProductDetailsPage products = new ProductDetailsPage(driver);
        CartDetailsPage cart = new CartDetailsPage(driver);

        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        Thread.sleep(2000);

        products.openProductsPage();
        Thread.sleep(3000);

        products.openFirstProductDetails();
        Thread.sleep(3000);

        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"));

        products.changeQuantity("4");
        Thread.sleep(1000);

        products.addCurrentProductToCart();
        Thread.sleep(2000);

        products.openCart();

        Thread.sleep(3000);
        Assert.assertEquals(cart.getQuantity(), "4");

    }
}
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartDetailsPage;
import pages.ProductDetailsPage;

public class TC17_RemoveProductsFromCart extends TestBase {

    @Test
    public void testRemoveProductFromCart() throws InterruptedException {

        ProductDetailsPage products = new ProductDetailsPage(driver);
        CartDetailsPage cart = new CartDetailsPage(driver);

        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        Thread.sleep(2000);

        products.openProductsPage();
        Thread.sleep(3000);

        products.addFirstProduct();
        Thread.sleep(3000);

        products.openCart();
        Thread.sleep(3000);

        Assert.assertEquals(cart.getProductsCount(), 1);

        cart.removeProduct();
        Thread.sleep(3000);

        Assert.assertEquals(cart.getProductsCount(), 0);

    }
}
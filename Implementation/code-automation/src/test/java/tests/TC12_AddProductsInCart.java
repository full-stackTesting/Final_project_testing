package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartDetailsPage;
import pages.ProductDetailsPage;

public class TC12_AddProductsInCart extends TestBase {

    @Test
    public void testAddTwoProductsToCart() throws InterruptedException {

        ProductDetailsPage products = new ProductDetailsPage(driver);
        CartDetailsPage cart = new CartDetailsPage(driver);

        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
        Thread.sleep(2000);

        products.openProductsPage();
        Thread.sleep(3000);

        products.addFirstProduct();
        Thread.sleep(2000);

        products.continueShopping();
        Thread.sleep(2000);
        products.addSecondProduct();

        Thread.sleep(2000);
        
        products.openCart();
        Thread.sleep(3000);

        Assert.assertEquals(cart.getProductsCount(), 2);

        Assert.assertTrue(cart.firstProductPriceDisplayed());
        Assert.assertTrue(cart.firstProductTotalDisplayed());

        Assert.assertTrue(cart.secondProductPriceDisplayed());
        Assert.assertTrue(cart.secondProductTotalDisplayed());

    }
}
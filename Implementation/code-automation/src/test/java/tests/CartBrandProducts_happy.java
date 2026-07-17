package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartBrandProducts;
import pages.HomePage;

public class CartBrandProducts_happy extends TestBase{

    HomePage homeObj;
    CartBrandProducts brandObj;

    public void initializeObj() {
        homeObj = new HomePage(driver);
        brandObj = new CartBrandProducts(driver);
    }

    @Test
    public void testPoloBrand() {
        initializeObj();
        homeObj.openProductsPage();
        Assert.assertTrue(brandObj.brandsTitle.isDisplayed());
        brandObj.openPolo();
        Assert.assertTrue(brandObj.successHeader.getText().toUpperCase().contains("POLO"));    }

    @Test
    public void testHMBrand() {
        initializeObj();
        homeObj.openProductsPage();
        Assert.assertTrue(brandObj.brandsTitle.isDisplayed());
        brandObj.openHM();
        Assert.assertTrue(brandObj.successHeader.getText().toUpperCase().contains("H&M"));    }

    @Test
    public void testMadameBrand() {
        initializeObj();
        homeObj.openProductsPage();
        brandObj.openMadame();
        Assert.assertTrue(brandObj.successHeader.getText().contains("MADAME"));
    }

    @Test
    public void testMastHarbourBrand() {
        initializeObj();
        homeObj.openProductsPage();
        brandObj.openMastHarbour();
        Assert.assertTrue(brandObj.successHeader.getText().contains("MAST"));
    }

    @Test
    public void testBabyhugBrand() {
        initializeObj();
        homeObj.openProductsPage();
        brandObj.openBabyhug();
        Assert.assertTrue(
             brandObj.successHeader.getText().toUpperCase().contains("BABYHUG"));
    }

    @Test
    public void testAllenSollyJuniorBrand() {
        initializeObj();
        homeObj.openProductsPage();
        brandObj.openAllenSollyJunior();
        Assert.assertTrue(brandObj.successHeader.getText().contains("ALLEN"));
    }

    @Test
    public void testKookieKidsBrand() {
        initializeObj();
        homeObj.openProductsPage();
        brandObj.openKookieKids();
        Assert.assertTrue(brandObj.successHeader.getText().contains("KOOKIE"));
    }

    @Test
    public void testBibaBrand() {
        initializeObj();
        homeObj.openProductsPage();
        brandObj.openBiba();
        Assert.assertTrue(brandObj.successHeader.getText().contains("BIBA"));
    }
}
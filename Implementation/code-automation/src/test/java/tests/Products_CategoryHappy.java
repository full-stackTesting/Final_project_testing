package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Products_CategoryAnd_Brands;

public class Products_CategoryHappy extends TestBase {
 HomePage homeObj;
 Products_CategoryAnd_Brands productObj;
  public void initializeObj() {
   homeObj =new HomePage(driver);
   productObj=new Products_CategoryAnd_Brands(driver);
  
 }
  @Test
  public void testWomenDress() {
      initializeObj();
      homeObj.openProductsPage();
      productObj.userCanOpenKidsCtegoryAndDress();
      Assert.assertTrue(productObj.SucesscategoryHeader.getText().contains("Dress"));
  }

  @Test
  public void testWomenTops() {
      initializeObj();
      homeObj.openProductsPage();
      productObj.userCanOpenWomenCtegoryAndTops();
      Assert.assertTrue(productObj.SucesscategoryHeader.getText().contains("TOPS"));
  }


  @Test
  public void testWomenSaree() {
      initializeObj();
      homeObj.openProductsPage();
      productObj.userCanOpenWomenCtegoryAndSaree();
      Assert.assertTrue(productObj.SucesscategoryHeader.getText().contains("Saree"));
  }
  @Test
  public void testMenTshirts() {
      initializeObj();
      homeObj.openProductsPage();
      productObj.userCanOpenMenCtegoryAndTshirts();
      Assert.assertTrue(productObj.SucesscategoryHeader.getText().contains("Tshirts"));
  }

  @Test
  public void testMenJeans() {
      initializeObj();
      homeObj.openProductsPage();
      productObj.userCanOpenMenCtegoryAndJeans();
      Assert.assertTrue(productObj.SucesscategoryHeader.getText().contains("Jeans"));
  }

  @Test
  public void testKidsDress() {
      initializeObj();
      homeObj.openProductsPage();
      productObj.userCanOpenKidsCtegoryAndDress();
      Assert.assertTrue(productObj.SucesscategoryHeader.getText().contains("Dress"));
  }

  @Test
  public void testKidsTopsAndShirts() {
      initializeObj();
      homeObj.openProductsPage();
      productObj.userCanOpenKidsCtegoryAndTops_Shirts();
      Assert.assertTrue(productObj.SucesscategoryHeader.getText().contains("TOPS"));
  }
}
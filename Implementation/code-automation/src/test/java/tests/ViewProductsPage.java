package tests;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.LoadReviewData;
import pages.HomePage;
import pages.ProductsPage;
public class ViewProductsPage extends TestBase{
	
	HomePage homeObject;
	ProductsPage productObject;
	
	public void initializeObjects() {
		homeObject = new HomePage(driver);
		productObject = new ProductsPage(driver);
	}
	
	@DataProvider(name = "ReviewData")
	public Object[][] getReviewData() throws IOException {
		return LoadReviewData.getReviewData();
	}
	
	int count = 0;
  @Test(dataProvider = "ReviewData")
  public void verifyAllProductsAndProductDetailPage(String name, String email,String review) throws InterruptedException{
	  initializeObjects();
	  Assert.assertEquals(homeObject.homePageBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");
	  homeObject.openProductsPage();
	  productObject.wait.until(ExpectedConditions.visibilityOf(productObject.allProductsMsg));
//	  Assert.assertTrue(productObject.allProductsMsg.getText().equalsIgnoreCase("All Products"));
	  Assert.assertTrue(productObject.productList.size() > 0);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy({top: 500, behavior: 'smooth'});");
	  productObject.viewFirstProductPage();
	  Assert.assertTrue(productObject.writeReviewTab.isDisplayed());
	  js.executeScript("window.scrollBy({top: 600, behavior: 'smooth'});");
	  productObject.submitReview(name,email,review);
	  Assert.assertTrue(productObject.reviewSuccessMsg.getText().equalsIgnoreCase("Thank you for your review."));
	  count++;
	  
  }
}
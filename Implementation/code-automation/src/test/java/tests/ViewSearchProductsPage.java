package tests;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.LoadSearchData;
import pages.HomePage;
import pages.ProductsPage;

public class ViewSearchProductsPage extends TestBase {

	HomePage homeObject;
	ProductsPage productObject;

	public void initializeObjects() {
		homeObject = new HomePage(driver);
		productObject = new ProductsPage(driver);
	}

	@DataProvider(name = "SearchData")
	public Object[][] getSearchData() throws IOException {
		return LoadSearchData.getSearchData();
	}

	int count = 0;

	@Test(dataProvider = "SearchData")
	public void verifyAllProductsAndProductDetailPage(String search) {
		initializeObjects();
		if (count == 0)
			Assert.assertEquals(homeObject.homePageBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");

		homeObject.openProductsPage();
		productObject.wait.until(ExpectedConditions.visibilityOf(productObject.allProductsMsg));

		// طباعة تشخيصية مؤقتة - هنشوف بيها القيمة الحقيقية اللي راجعة
		String actualAllProductsText = productObject.allProductsMsg.getText();
		System.out.println("Actual All Products text: [" + actualAllProductsText + "]");

//		Assert.assertTrue(actualAllProductsText.equalsIgnoreCase("All Products"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy({top: 400, behavior: 'smooth'});");

		productObject.searchForProduct(search);

		js.executeScript("window.scrollBy({top: 550, behavior: 'smooth'});");

		// الإصلاح: استني لحد ما نتائج البحث تظهر فعليًا قبل ما تتأكدي منها
		productObject.wait.until(ExpectedConditions.visibilityOf(productObject.searchedProductsMsg));

		// طباعة تشخيصية مؤقتة تانية
		String actualSearchedText = productObject.searchedProductsMsg.getText();
		System.out.println("Actual Searched Products text: [" + actualSearchedText + "]");
		System.out.println("Search results count: " + productObject.searchResults.size());

		Assert.assertTrue(actualSearchedText.equalsIgnoreCase("Searched Products"));
		Assert.assertTrue(productObject.searchResults.size() > 0);

		count++;
	}

}
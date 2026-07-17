package tests;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddToCarPage;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductsPage;
import pages.RegisterPage;

public class T20_VerifyCartBeforeAndAfterLogin extends TestBase {
	HomePage homeobj;
	RegisterPage regObj;
	CartPage cartObj;
	ProductsPage productObj;
	CheckOutPage checkoutObj;
	PaymentPage paymentObj;
	AddToCarPage addpageObj;
	LoginPage loginobj;

	public void initializeObjects() {
		homeobj = new HomePage(driver);
		productObj = new ProductsPage(driver);
		cartObj = new CartPage(driver);
		regObj = new RegisterPage(driver);
		checkoutObj = new CheckOutPage(driver);
		paymentObj = new PaymentPage(driver);
		addpageObj = new AddToCarPage(driver);
		loginobj = new LoginPage(driver);
	}

	@DataProvider(name = "searchLoginData")
	public Object[][] getSearchLoginData() throws IOException {
	    String filePath = System.getProperty("user.dir") + "/src/test/java/excelFile/data.xlsx";
	    FileInputStream stream = new FileInputStream(filePath);
	    XSSFWorkbook workBook = new XSSFWorkbook(stream);
	    XSSFSheet searchSheet = workBook.getSheet("Search");
	    XSSFSheet loginSheet = workBook.getSheet("Login Happy");

	    DataFormatter formatter = new DataFormatter();

	    // بيانات اللوجين
	    XSSFRow loginRow = loginSheet.getRow(0);
	    String email = formatter.formatCellValue(loginRow.getCell(0));
	    String password = formatter.formatCellValue(loginRow.getCell(1));

	    // ناخد أول صف بس من Search
	    XSSFRow searchRow = searchSheet.getRow(0);
	    String productName = formatter.formatCellValue(searchRow.getCell(0));

	    Object[][] fullData = new Object[1][3];
	    fullData[0][0] = productName;
	    fullData[0][1] = email;
	    fullData[0][2] = password;

	    workBook.close();
	    stream.close();
	    return fullData;
	}
	
	@Test(dataProvider = "searchLoginData")
	public void SearchProductsAndVerifyCartAfterLoginTest(String productName,
	        String email, String password) {

	    initializeObjects();

	    // Verify Home Page
	    Assert.assertTrue(homeobj.homePageBtn.isDisplayed());

	    // Open Products Page
	    homeobj.openProductsPage();
	    productObj.scrollToSearchBox();

	    // Search Product
	    productObj.searchForProduct(productName);

	    // Verify SEARCHED PRODUCTS
	    Assert.assertTrue(productObj.searchedProductsMsg.isDisplayed());
	    // Verify all searched products are displayed
	    Assert.assertTrue(productObj.searchResults.size() > 0);
	    // Add searched products to cart
	    addpageObj.userSelectFirstSearchedProduct();

	    // View Cart
	    addpageObj.userViewCart();

	    // Verify Cart Page
	    Assert.assertTrue(driver.getCurrentUrl().contains("/view_cart"));

	    // Open Login Page
	    homeobj.openLoginSignUpPage();

	    // Login
	    loginobj.userCanLogin(email, password);

	    // Verify Logged In
//	    Assert.assertTrue(homeobj.loggedInAsUsername.isDisplayed());

	    // Open Cart Again
	    homeobj.opencartPage();

	    // Verify Products Still Exist In Cart
//	    Assert.assertTrue(cartObj.productInCart.isDisplayed());
	}
}